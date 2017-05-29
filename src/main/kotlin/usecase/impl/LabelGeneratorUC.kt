package usecase.impl

import domain.businessrules.ITextBR
import domain.poco.Position
import domain.poco.Text
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import usecase.ILabelGeneratorUC
import java.awt.Color
import java.awt.Font

@Service
class LabelGeneratorUC @Autowired constructor(val textBR: ITextBR) : ILabelGeneratorUC {
    override fun generateLabelByRegexAndCanvasDimension(regex: String, sizeX: Int, sizeY: Int): List<Pair<Text, Position>> {
        val text = textBR.generateTextFromRegex(regex, Font("TimesRoman", Font.PLAIN, 50), Color.blue)
        val position = Position(sizeX, sizeY)

        val tupple = Pair(text, position)
        return listOf(tupple)
    }
}


