package domain.businessrules.impl

import domain.businessrules.ITextBR
import domain.poco.Text
import infrastructure.IRegexGeneratorHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.Color
import java.awt.Font

@Service
open class TextBR @Autowired constructor(val regexGeneratorHandler: IRegexGeneratorHandler) : ITextBR {
    override fun generateTextFromRegex(regex: String, font: Font, color: Color): Text {
        val generatedString = regexGeneratorHandler.generateStringFromRegex(regex)
        return Text(generatedString, font, color)
    }

}