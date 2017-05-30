package service

import domain.Request
import domain.Text
import java.awt.image.BufferedImage

interface IResultService {
    fun generateResult(request: Request, imageTextList: List<Pair<BufferedImage, Text>>): Unit

}