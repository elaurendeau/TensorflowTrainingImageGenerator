package manager.impl

import com.rits.cloning.Cloner
import domain.Position
import domain.Text
import infrastructure.IFontHandler
import infrastructure.IImageHandler
import infrastructure.impl.FontHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import manager.IImageManager
import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.image.BufferedImage
import java.util.concurrent.ThreadLocalRandom

@Service
class ImageManager @Autowired constructor(val imageHandler: IImageHandler) : IImageManager {
    override fun appendLabelsToImage(image: BufferedImage, labels: List<Pair<Text, Position>>): List<Pair<BufferedImage, Text>> {
        val cloner = Cloner()
        return labels.map {
            Pair(imageHandler.writeTextOnImageAtSpecificPosition(cloner.deepClone(image), it.second, it.first), it.first)
        }
    }
}