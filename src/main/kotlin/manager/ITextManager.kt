package manager

import domain.Text

interface ITextManager {
    fun generateTextFromRegex(regex: String, occurrence: Int): List<Text>
}