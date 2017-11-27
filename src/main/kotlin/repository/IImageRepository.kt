package repository

import domain.Request
import java.awt.image.BufferedImage

interface IImageRepository {
    fun persist(request: Request, imageLabelPairList: List<Pair<BufferedImage, String>>)
}