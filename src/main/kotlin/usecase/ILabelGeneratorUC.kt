package usecase

import domain.poco.Position
import domain.poco.Text

interface ILabelGeneratorUC {
    fun writeOnImage(regex: String, positionX: Int, positionY: Int): List<Pair<Text, Position>>
}