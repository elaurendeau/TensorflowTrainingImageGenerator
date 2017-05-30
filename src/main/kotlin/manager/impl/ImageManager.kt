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
    override fun appendLabelToImage(image: BufferedImage, label: Pair<Text, Position>): Pair<BufferedImage, Text> {
        return Pair(imageHandler.writeTextOnImageAtSpecificPosition(imageHandler.copyImage(image), label.second, label.first), label.first)
    }
}