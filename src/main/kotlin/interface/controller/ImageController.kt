package `interface`.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import usecase.IImageUC
import usecase.impl.LabelGeneratorUC
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.net.URL
import javax.imageio.ImageIO

@Component
open class ImageController @Autowired constructor(val labelGeneratorUC: LabelGeneratorUC, val imageAppenderUC: IImageUC) {

    fun run(url: String, savePath: String) {
        val img = ImageIO.read(URL(url))

        val listLabelAndPosition = labelGeneratorUC.generateLabelByRegexAndCanvasDimension("[A-Z]{4,8}", 100, 100)
        val imageList = imageAppenderUC.appendLabelsToImage(img, listLabelAndPosition)

        imageList.forEach {
            val byteArrayOutputStream = ByteArrayOutputStream();
            ImageIO.write(it.first, "png", byteArrayOutputStream);
            FileOutputStream(savePath + "\\" + it.second.label + ".png").write(byteArrayOutputStream.toByteArray());
        }
    }


}