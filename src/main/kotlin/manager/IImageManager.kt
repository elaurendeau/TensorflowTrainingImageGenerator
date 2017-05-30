package manager

import domain.Position
import domain.Text
import java.awt.image.BufferedImage

interface IImageManager {
    fun appendLabelToImage(image: BufferedImage, label: Pair<Text, Position>): Pair<BufferedImage, Text>
}