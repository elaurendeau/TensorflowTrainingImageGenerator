package controller

import dto.ImageTestResultRequest
import dto.RestResponse
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import service.ILabelGeneratorService
import java.net.URL
import javax.imageio.ImageIO

@RequestMapping("/rest")
@RestController
open class TrainingRequestController @Autowired constructor(val labelGenerator: ILabelGeneratorService) {

    @RequestMapping(value = "/generate", method = arrayOf(RequestMethod.POST))
    fun generateTestResults(@RequestBody imageTestResultRequest: ImageTestResultRequest): Unit {
        val image = ImageIO.read(URL(imageTestResultRequest.imagePath))
        async(CommonPool) {
            labelGenerator.generateLabelByRegexAndCanvasDimension(image, imageTestResultRequest.regex, image.width, image.height, imageTestResultRequest.occurrence, imageTestResultRequest.request)
        }
    }

    @RequestMapping(value = "/responseReceiveTest", method = arrayOf(RequestMethod.POST))
    fun getResponse(@RequestBody response: RestResponse): Unit {
        println(response.label)
    }

}