package infrastructure.impl

import com.mifmif.common.regex.Generex
import infrastructure.IRegexGeneratorHandler
import org.springframework.stereotype.Service

@Service
class RegexGeneratorHandler : IRegexGeneratorHandler {
    override fun generateNStringFromRegex(regex: String, occurrence: Int): List<String> {
        return Generex(regex).getMatchedStrings(occurrence)
    }

    override fun generateStringFromRegex(regex: String): String {
        return Generex(regex).random()
    }
}