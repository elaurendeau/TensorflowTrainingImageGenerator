package usecase

import domain.poco.Position
import domain.poco.Text

interface ILabelGeneratorUC {
    fun generateLabelByRegexAndCanvasDimension(regex: String, sizeX: Int, sizeY: Int): List<Pair<Text, Position>>
}