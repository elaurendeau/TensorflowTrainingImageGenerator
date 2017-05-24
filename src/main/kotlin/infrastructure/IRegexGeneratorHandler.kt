package infrastructure

interface IRegexGeneratorHandler {
    fun generateStringFromRegex(regex: String): String
}