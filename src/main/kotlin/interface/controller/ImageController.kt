package `interface`.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import usecase.impl.LabelGeneratorUC
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val labelGeneratorUC: LabelGeneratorUC) {

    fun run(url: String) {
        val img = ImageIO.read(URL(url))

        val listLabelAndPosition = labelGeneratorUC.generateLabelByRegexAndCanvasDimension("[A-Z]{4,8}", 100, 100)
        listLabelAndPosition.forEach {
            println(it.first.label)
        }
//        val modifiedImage = imageHandler.writeTextOnImageAtSpecificPosition(img, Position(100,100), Text("Test", Font("TimesRoman", Font.PLAIN, 50), Color.black))
//        val byteArrayOutputStream = ByteArrayOutputStream();
//        ImageIO.write(modifiedImage, "png", byteArrayOutputStream);
//        FileOutputStream("test.png").write(byteArrayOutputStream.toByteArray());
    }


}