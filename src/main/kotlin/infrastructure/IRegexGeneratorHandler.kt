package infrastructure

interface IRegexGeneratorHandler {
    fun generateNStringFromRegex(regex: String, occurrence: Int): List<String>

    fun generateStringFromRegex(regex: String): String
}