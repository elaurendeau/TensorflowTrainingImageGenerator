package infrastructure

import domain.RestRequest
import java.awt.image.BufferedImage

interface IRestRequestHandler {
    fun send(request: RestRequest, imageLabelPairList: List<Pair<BufferedImage, String>>): Unit
}