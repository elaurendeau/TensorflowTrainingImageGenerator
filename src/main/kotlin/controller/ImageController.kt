package controller

import domain.FileRequest
import manager.IImageManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import service.IResultService
import service.impl.LabelGeneratorService
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val labelGenerator: LabelGeneratorService, val imageAppender: IImageManager, val resultService: IResultService) {

    fun run(url: String, savePath: String, regex: String, occurrence: Int) {
        val image = ImageIO.read(URL(url))

        val listLabelAndPosition = labelGenerator.generateLabelByRegexAndCanvasDimension(image, regex, 100, 100, occurrence, savePath)
    }
}