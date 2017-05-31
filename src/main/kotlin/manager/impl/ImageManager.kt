package manager.impl

import domain.Position
import domain.Text
import infrastructure.IImageHandler
import manager.IImageManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage

@Service
class ImageManager @Autowired constructor(val imageHandler: IImageHandler) : IImageManager {
    override fun appendLabelToImage(image: BufferedImage, label: Pair<Text, Position>): Pair<BufferedImage, Text> {
        return Pair(imageHandler.writeTextOnImageAtSpecificPosition(imageHandler.copyImage(image), label.second, label.first), label.first)
    }
}