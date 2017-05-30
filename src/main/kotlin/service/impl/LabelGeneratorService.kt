package service.impl

import domain.Position
import domain.Request
import domain.Text
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import manager.IImageManager
import manager.ITextManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.IImageRepository
import service.ILabelGeneratorService
import java.awt.image.BufferedImage

@Service
class LabelGeneratorService @Autowired constructor(val textManager: ITextManager, val imageAppender: IImageManager, val imageRepository: IImageRepository) : ILabelGeneratorService {

    override fun generateLabelByRegexAndCanvasDimension(image: BufferedImage, regex: String, sizeX: Int, sizeY: Int, occurrence: Int, path: String, request: Request) {

        val position = Position(sizeX, sizeY)
        val channel = Channel<Pair<Text, Position>>(occurrence)

        launch(CommonPool) {
            repeat(occurrence) {
                channel.send(Pair(textManager.generateTextFromRegex(regex), position))
            }
            channel.close()
        }

        runBlocking {
            val jobList = List(100_0) {
                launch(CommonPool) {
                    for (pair in channel) {
                        val imageLabelPair = imageAppender.appendLabelToImage(image, pair)
                        imageRepository.persist(request, imageLabelPair.first, imageLabelPair.second.label)
                    }
                }
            }

            jobList.forEach {
                it.join()
            }
        }
    }
}


