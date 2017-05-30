package infrastructure

import domain.FileRequest
import java.awt.image.BufferedImage

interface IFileRequestHandler {
    fun persist(request: FileRequest, image: BufferedImage, label: String): Unit
}