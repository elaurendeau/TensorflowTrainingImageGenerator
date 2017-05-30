package controller

import domain.FileRequest
import manager.IImageManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import service.impl.LabelGeneratorService
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val labelGenerator: LabelGeneratorService) {

    fun run(url: String, savePath: String, regex: String, occurrence: Int) {
        val image = ImageIO.read(URL(url))

        labelGenerator.generateLabelByRegexAndCanvasDimension(image, regex, 100, 100, occurrence, savePath, FileRequest(savePath))
    }
}