package repository.impl

import repository.IImageRepository
import domain.FileRequest
import domain.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import javax.imageio.ImageIO

@Service
class ImageRepository @Autowired constructor(): IImageRepository {
    companion object {
        val EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE = "Invalid request type actual: %s"
    }

    override fun persist(request: Request, image: BufferedImage, text: String) {
        when(request) {
            is FileRequest -> {
                val byteArrayOutputStream = ByteArrayOutputStream();
                ImageIO.write(image, "png", byteArrayOutputStream);
                FileOutputStream(request.path + "\\" + text + ".png").write(byteArrayOutputStream.toByteArray());
            }
            else -> throw IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE.format(request.javaClass.kotlin.toString()))
        }
    }
}