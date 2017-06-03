package controller

import domain.FileRequest
import dto.ImageTestResultRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import service.ILabelGeneratorService
import java.net.URL
import javax.imageio.ImageIO
import javax.validation.Valid

@RequestMapping("/rest")
@RestController
open class TrainingRequestController @Autowired constructor(val labelGenerator: ILabelGeneratorService) {

    @RequestMapping(value="/generate", method= arrayOf(RequestMethod.POST))
    fun generateTestResults(@RequestBody imageTestResultRequest: ImageTestResultRequest): Unit {
        val image = ImageIO.read(URL(imageTestResultRequest.imagePath))

        labelGenerator.generateLabelByRegexAndCanvasDimension(image, imageTestResultRequest.regex, image.width, image.height, imageTestResultRequest.occurrence, imageTestResultRequest.callbackUrl, FileRequest(imageTestResultRequest.callbackUrl))
    }

}