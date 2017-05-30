package service.impl

import domain.FileRequest
import domain.Position
import domain.Text
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import manager.IImageManager
import manager.ITextManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import service.ILabelGeneratorService
import service.IResultService
import java.awt.image.BufferedImage
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.experimental.buildSequence

@Service
class LabelGeneratorService @Autowired constructor(val textManager: ITextManager, val imageAppender: IImageManager, val resultService: IResultService) : ILabelGeneratorService {

    override fun generateLabelByRegexAndCanvasDimension(image: BufferedImage, regex: String, sizeX: Int, sizeY: Int, occurrence: Int, path: String) {

        val position = Position(sizeX, sizeY)
        val channel = Channel<Pair<Text, Position>>(occurrence)

        launch(CommonPool) {
            repeat(occurrence) {
                channel.send(Pair(textManager.generateTextFromRegex(regex), position))
            }
            channel.close()
        }

        runBlocking {
            val workerCount = 10
            val waitGroup = AtomicInteger(workerCount)
            for (n in 1..10) {
                async(CommonPool) {
                    while (!channel.isClosedForReceive) {
                        val imageList = imageAppender.appendLabelsToImage(image, listOf(channel.receive()))
                        resultService.generateResult(FileRequest(path), imageList)
                    }
                    waitGroup.addAndGet(-1)
                }.await()
            }
        }
    }
}


