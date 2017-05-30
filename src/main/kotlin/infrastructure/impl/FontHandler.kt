package infrastructure.impl

import infrastructure.IFontHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.Font
import java.awt.GraphicsEnvironment

@Service
class FontHandler @Autowired constructor(): IFontHandler{
    override fun getFontNames(): List<String> {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().allFonts.map {
            it.fontName
        }
    }
}