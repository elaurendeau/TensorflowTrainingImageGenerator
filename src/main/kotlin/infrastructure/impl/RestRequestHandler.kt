package infrastructure.impl

import domain.FileRequest
import domain.Request
import domain.RestRequest
import dto.RestResponse
import infrastructure.IFileRequestHandler
import infrastructure.IRestRequestHandler
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.awt.image.WritableRaster
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import javax.imageio.ImageIO

@Service
class RestRequestHandler : IRestRequestHandler {
    override fun send(request: RestRequest, image: BufferedImage, label: String) {
        async(CommonPool) {
            val template = RestTemplate()
            val data: DataBufferByte = image.raster.dataBuffer as DataBufferByte
            val response = RestResponse(data.data, label)

            template.postForObject(request.callback, response, RestResponse::class.java, HashMap<String, String>())
        }
    }
}