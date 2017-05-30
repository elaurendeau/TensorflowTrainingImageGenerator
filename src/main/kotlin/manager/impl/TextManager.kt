package manager.impl

import domain.Text
import infrastructure.IFontHandler
import infrastructure.IRegexGeneratorHandler
import manager.ITextManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.awt.Color
import java.awt.Font
import java.util.concurrent.ThreadLocalRandom

@Service
open class TextManager @Autowired constructor(val regexGeneratorHandler: IRegexGeneratorHandler, val fontHandler: IFontHandler) : ITextManager {

    val fontList: List<Font> by lazy {
        fontHandler.getFontNames().map {
            Font(it, FONT_DECORATION[ThreadLocalRandom.current().nextInt(FONT_DECORATION.size)], ThreadLocalRandom.current().nextInt(FONT_SIZE_MIN, FONT_SIZE_MAX))
        }.toList()
    }

    val colorList: List<Color> by lazy {
        COLOR_CODE_LIST.map {
            Color.decode(it)
        }
    }

    override fun generateTextFromRegex(regex: String): Text {
        val generatedString = regexGeneratorHandler.generateStringFromRegex(regex)

        return Text(generatedString, fontList[ThreadLocalRandom.current().nextInt(fontList.size)], colorList[ThreadLocalRandom.current().nextInt(colorList.size)])
    }

    companion object {
        val FONT_DECORATION = listOf(Font.BOLD, Font.PLAIN, Font.ITALIC)
        val FONT_SIZE_MIN = 25
        val FONT_SIZE_MAX = 75
        val COLOR_CODE_LIST = listOf("#FFA07A",
                "#F0F8FF",
                "#20B2AA",
                "#FAEBD7",
                "#87CEFA",
                "#00FFFF",
                "#778899",
                "#7FFFD4",
                "#B0C4DE",
                "#F0FFFF",
                "#FFFFE0",
                "#F5F5DC",
                "#00FF00",
                "#FFE4C4",
                "#32CD32",
                "#000000",
                "#FAF0E6",
                "#FFEBCD",
                "#FF00FF",
                "#0000FF",
                "#800000",
                "#8A2BE2",
                "#66CDAA",
                "#A52A2A",
                "#0000CD",
                "#DEB887",
                "#BA55D3",
                "#5F9EA0",
                "#9370DB",
                "#7FFF00",
                "#3CB371",
                "#D2691E",
                "#7B68EE",
                "#FF7F50",
                "#6495ED",
                "#48D1CC",
                "#FFF8DC",
                "#DC143C",
                "#191970",
                "#00FFFF",
                "#F5FFFA",
                "#00008B",
                "#FFE4E1",
                "#008B8B",
                "#B8860B",
                "#B8860B",
                "#FFDEAD",
                "#A9A9A9",
                "#000080",
                "#006400",
                "#FDF5E6",
                "#BDB76B",
                "#808000",
                "#8B008B",
                "#6B8E23",
                "#556B2F",
                "#FFA500",
                "#FF8C00",
                "#FF4500",
                "#9932CC",
                "#DA70D6",
                "#8B0000",
                "#EEE8AA",
                "#E9967A",
                "#98FB98",
                "#8FBC8F",
                "#AFEEEE",
                "#483D8B",
                "#DB7093",
                "#2F4F4F",
                "#FFEFD5",
                "#00CED1",
                "#FFDAB9",
                "#9400D3",
                "#CD853F",
                "#FF1493",
                "#FFC0CB",
                "#00BFFF",
                "#DDA0DD",
                "#696969",
                "#1E90FF",
                "#1E90FF",
                "#800080",
                "#B22222",
                "#FF0000",
                "#FFFAF0",
                "#BC8F8F",
                "#228B22",
                "#4169E1",
                "#FF00FF",
                "#8B4513",
                "#DCDCDC",
                "#FA8072",
                "#F8F8FF",
                "#FAA460",
                "#FFD700",
                "#2E8B57",
                "#DAA520",
                "#FFF5EE",
                "#808080",
                "#A0522D",
                "#008000",
                "#C0C0C0",
                "#ADFF2F",
                "#F0FFF0",
                "#6A5ACD",
                "#FF69B4",
                "#708090",
                "#CD5C5C",
                "#FFFAFA",
                "#4B0082",
                "#00FF7F",
                "#FFFFF0",
                "#4682B4",
                "#F0E68C",
                "#E6E6FA",
                "#E6E6FA",
                "#008080",
                "#FFF0F5",
                "#7CFC00",
                "#7CFC00",
                "#FF6347",
                "#FFFACD",
                "#40E0D0",
                "#ADD8E6",
                "#EE82EE",
                "#F08080",
                "#F5DEB3",
                "#E0FFFF",
                "#FAFAD2",
                "#FAFAD2",
                "#F5F5F5",
                "#90EE90",
                "#FFFF00",
                "#D3D3D3",
                "#9ACD32",
                "#FFB6C1")
    }

}