package infrastructure.impl

import domain.Position
import domain.Text
import infrastructure.IImageHandler
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage

@Service
class ImageHandler : IImageHandler {
    override fun writeTextOnImageAtSpecificPosition(image: BufferedImage, position: Position, text: Text): BufferedImage {
        val graphicImage = image.createGraphics()
        graphicImage.font = text.font
        graphicImage.color = text.color
        graphicImage.drawString(text.label , position.x, position.y)

        return image;
    }
}
