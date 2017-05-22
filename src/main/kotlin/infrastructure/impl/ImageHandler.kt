package infrastructure.impl

import domain.poco.Position
import domain.poco.Text
import infrastructure.IImageHandler
import java.awt.image.BufferedImage

class ImageHandler : IImageHandler {
    override fun writeTextOnImageAtSpecificPosition(image: BufferedImage, position: Position, text: Text): BufferedImage {
        val graphicImage = image.createGraphics()
        graphicImage.font = text.font
        graphicImage.color = text.color
        graphicImage.drawString(text.label , position.x, position.y)

        return image;
    }
}
