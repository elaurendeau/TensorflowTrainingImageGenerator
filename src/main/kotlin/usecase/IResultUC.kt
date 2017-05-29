package usecase

import `interface`.controller.poco.Request
import domain.poco.Text
import java.awt.image.BufferedImage

interface IResultUC {
    fun generateResult(request: Request, imageTextList: List<Pair<BufferedImage, Text>>): Unit

}