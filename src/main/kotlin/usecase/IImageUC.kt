package usecase

import domain.poco.Position
import domain.poco.Text
import java.awt.image.BufferedImage

interface IImageUC {
    fun appendLabelsToImage(image: BufferedImage, labels: List<Pair<Text, Position>>): List<Pair<BufferedImage, Text>>
}