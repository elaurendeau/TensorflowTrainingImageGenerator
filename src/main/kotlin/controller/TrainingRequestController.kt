package controller

import dto.ImageTestResultRequest
import dto.RestResponse
import enumeration.LoggingLevelEnumeration
import infrastructure.ILoggerHandler
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
open class TrainingRequestController @Autowired constructor(val labelGenerator: ILabelGeneratorService, val logger: ILoggerHandler) {

    @RequestMapping(value = "/generate", method = arrayOf(RequestMethod.POST))
    fun generateTestResults(@RequestBody imageTestResultRequest: ImageTestResultRequest): Unit {
        logger.log(LoggingLevelEnumeration.INFO, "Generating %s times %s".format(imageTestResultRequest.occurrence, imageTestResultRequest.regex))
        val image = ImageIO.read(URL(imageTestResultRequest.imagePath))
        labelGenerator.generateLabelByRegexAndCanvasDimension(image, imageTestResultRequest.regex, image.width, image.height, imageTestResultRequest.occurrence, imageTestResultRequest.batchSize, imageTestResultRequest.request)
    }


    @RequestMapping(value = "/responseReceiveTest", method = arrayOf(RequestMethod.POST))
    fun getResponse(@RequestBody response: RestResponse): Unit {
        println("----- Batch size: " + response.imageLabelPairList.size)
        response.imageLabelPairList.forEach {
            println(it.second)
        }
    }

}