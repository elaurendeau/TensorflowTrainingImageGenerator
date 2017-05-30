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

    fun run(url: String, savePath: String) {
        val img = ImageIO.read(URL(url))

        val listLabelAndPosition = labelGenerator.generateLabelByRegexAndCanvasDimension("[A-Z]{1,3}", 100, 100, 0)
        val imageList = imageAppender.appendLabelsToImage(img, listLabelAndPosition)
        resultService.generateResult(FileRequest("D:\\tmp\\testdata"), imageList)
    }
}