package infrastructure.impl

import com.mifmif.common.regex.Generex
import infrastructure.IRegexGeneratorHandler
import org.springframework.stereotype.Service

@Service
class RegexGeneratorHandler : IRegexGeneratorHandler {
    override fun generateStringFromRegex(regex: String): String {
        return Generex(regex).random()
    }

    companion object {
        val EXCEPTION_MESSAGE_INFINITE_POSSIBILITIES = "Infinite possibilities to match every occurrence of the regex [%s]"
    }

    override fun generateNStringFromRegex(regex: String, occurrence: Int): List<String> {
        val generex = Generex(regex)
        generex.setSeed(System.currentTimeMillis())

        if(generex.isInfinite && occurrence == 0) {
            throw StackOverflowError(EXCEPTION_MESSAGE_INFINITE_POSSIBILITIES.format(regex))
        }

        return if(occurrence == 0) generex.allMatchedStrings else generex.getMatchedStrings(occurrence)
    }
}