package infrastructure.impl

import domain.RestRequest
import dto.RestResponse
import infrastructure.IRestRequestHandler
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte

@Service
class RestRequestHandler : IRestRequestHandler {
    override fun send(request: RestRequest, image: BufferedImage, label: String) {
        val template = RestTemplate()
        val data: DataBufferByte = image.raster.dataBuffer as DataBufferByte
        val response = RestResponse(data.data, label)

        template.postForObject(request.callback, response, String::class.java, HashMap<String, String>())
    }
}