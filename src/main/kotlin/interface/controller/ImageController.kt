package `interface`.controller

import domain.poco.Position
import domain.poco.Text
import infrastructure.IImageHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.awt.Color
import java.awt.Font
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val imageHandler: IImageHandler) {

    fun run(url: String) {

        val img = ImageIO.read(URL(url))

        val modifiedImage = imageHandler.writeTextOnImageAtSpecificPosition(img, Position(100,100), Text("Test", Font("TimesRoman", Font.PLAIN, 50), Color.black))
        val byteArrayOutputStream = ByteArrayOutputStream();
        ImageIO.write(modifiedImage, "png", byteArrayOutputStream);
        FileOutputStream("test.png").write(byteArrayOutputStream.toByteArray());
    }


}