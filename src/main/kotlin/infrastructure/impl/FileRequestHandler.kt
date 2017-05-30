package infrastructure.impl

import domain.FileRequest
import infrastructure.IFileRequestHandler
import org.springframework.stereotype.Service
import java.awt.SystemColor.text
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import javax.imageio.ImageIO

@Service
class FileRequestHandler: IFileRequestHandler{
    override fun persist(request: FileRequest, image: BufferedImage, label: String) {
        val byteArrayOutputStream = ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);
        FileOutputStream(request.path + "\\" + label + ".png").write(byteArrayOutputStream.toByteArray());
    }

}