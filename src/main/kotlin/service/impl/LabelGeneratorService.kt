package service.impl

import manager.ITextManager
import domain.Position
import domain.Text
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import service.ILabelGeneratorService
import java.awt.Color
import java.awt.Font
import java.awt.GraphicsEnvironment

@Service
class LabelGeneratorService @Autowired constructor(val textBR: ITextManager) : ILabelGeneratorService {

    override fun generateLabelByRegexAndCanvasDimension(regex: String, sizeX: Int, sizeY: Int, occurrence: Int): List<Pair<Text, Position>> {
        val textList = textBR.generateTextFromRegex(regex, occurrence)
        val position = Position(sizeX, sizeY)

        return textList.map {
            Pair(it, position)
        }
    }
}


