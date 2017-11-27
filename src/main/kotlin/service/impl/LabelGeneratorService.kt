package service.impl

import domain.Position
import domain.Request
import domain.Text
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import manager.IImageManager
import manager.IPositionManager
import manager.ITextManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.IImageRepository
import service.ILabelGeneratorService
import util.pmap
import java.awt.image.BufferedImage

@Service
class LabelGeneratorService @Autowired constructor(val textManager: ITextManager, val imageAppender: IImageManager, val imageRepository: IImageRepository, val positionManager: IPositionManager) : ILabelGeneratorService {

    /**
     * Generate a single text and position based on a regex
     * @param regex {@link String}
     * @param sizeX {@link Int}
     * @param sizeY {@link Int}
     *
     * @return {@link Pair}<{@link Text}, {@link Position}>
     *
     */
    private fun generateSingleLabelAndPosition(regex: String, sizeX: Int, sizeY: Int): Pair<Text, Position> {
//        TODO max retry scenario for infinite loop
        try {
            val text = textManager.generateTextFromRegex(regex)
            val position = positionManager.generateRandomPosition(text, sizeX, sizeY)
            return Pair(text, position)
        } catch (e: IllegalArgumentException) {
//                 Skip this exception. If it is invalid, we won't process it.
            e.printStackTrace()
            return generateSingleLabelAndPosition(regex, sizeX, sizeY)
        }
    }

    override fun generateLabelByRegexAndCanvasDimension(image: BufferedImage, regex: String, sizeX: Int, sizeY: Int, occurrence: Int, batchSize: Int, request: Request) {
        (1 .. occurrence).toList().parallelStream().forEach {

            val imageLabelPairList = (1 .. batchSize).toList().pmap {
                val imagePair = imageAppender.appendLabelToImage(image, generateSingleLabelAndPosition(regex, sizeX, sizeY))
                Pair(imagePair.first, imagePair.second.label)
            }
            imageRepository.persist(request, imageLabelPairList)

        }
    }

}


