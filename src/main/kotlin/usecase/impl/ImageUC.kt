package usecase.impl

import com.rits.cloning.Cloner
import domain.poco.Position
import domain.poco.Text
import infrastructure.IImageHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import usecase.IImageUC
import java.awt.image.BufferedImage

@Service
class ImageUC @Autowired constructor(val imageHandler: IImageHandler) : IImageUC {
    override fun appendLabelsToImage(image: BufferedImage, labels: List<Pair<Text, Position>>): List<Pair<BufferedImage, Text>> {
        val cloner = Cloner()
        return labels.map {
            Pair(imageHandler.writeTextOnImageAtSpecificPosition(cloner.deepClone(image), it.second, it.first), it.first)
        }
    }
}