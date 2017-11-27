package controller

import domain.FileRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import service.ILabelGeneratorService
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val labelGenerator: ILabelGeneratorService) {

    fun run(url: String, savePath: String, regex: String, occurrence: Int, batchSize: Int) {
        val image = ImageIO.read(URL(url))

        labelGenerator.generateLabelByRegexAndCanvasDimension(image, regex, image.width, image.height, occurrence, batchSize, FileRequest(savePath))

    }
}