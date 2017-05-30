package repository

import domain.Request
import java.awt.image.BufferedImage

interface IImageRepository {
    fun persist(request: Request, image: BufferedImage, text: String)
}