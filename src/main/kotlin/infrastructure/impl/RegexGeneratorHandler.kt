package infrastructure.impl

import com.mifmif.common.regex.Generex
import infrastructure.IRegexGeneratorHandler
import org.springframework.stereotype.Component

@Component
class RegexGeneratorHandler: IRegexGeneratorHandler {
    override fun generateStringFromRegex(regex: String): String {
        val generex = Generex(regex)
        return generex.random()
    }
}