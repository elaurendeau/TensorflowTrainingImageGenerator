package domain.businessrules

import domain.poco.Text
import java.awt.Color
import java.awt.Font

interface ITextBR {
    fun generateTextFromRegex(regex: String, font: Font, color: Color): Text
}