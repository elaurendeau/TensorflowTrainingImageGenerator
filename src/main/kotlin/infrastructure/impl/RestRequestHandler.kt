package infrastructure.impl

import domain.RestRequest
import dto.RestResponse
import infrastructure.IRestRequestHandler
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.util.*
import javax.imageio.ImageIO


@Service
class RestRequestHandler : IRestRequestHandler {
    override fun send(request: RestRequest, image: BufferedImage, label: String) {
        fun imageRestFormat(image: BufferedImage): String {
            val byteArrayOutputStream = ByteArrayOutputStream()
            ImageIO.write(image, "jpg", byteArrayOutputStream)
            val bytes = byteArrayOutputStream.toByteArray()
            return Base64.getEncoder().encodeToString(bytes)
        }

        val template = RestTemplate()
        val response = RestResponse(imageRestFormat(image), label)

        template.postForObject(request.callback, response, String::class.java, HashMap<String, String>())
    }
}