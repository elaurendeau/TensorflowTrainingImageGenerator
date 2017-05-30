package manager

import domain.Position
import domain.Text
import java.awt.image.BufferedImage

interface IImageManager {
    fun appendLabelsToImage(image: BufferedImage, labels: List<Pair<Text, Position>>): List<Pair<BufferedImage, Text>>
}