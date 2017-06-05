package infrastructure

import domain.RestRequest
import java.awt.image.BufferedImage

interface IRestRequestHandler {
    fun send(request: RestRequest, image: BufferedImage, label: String): Unit
}