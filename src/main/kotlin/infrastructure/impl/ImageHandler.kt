package infrastructure.impl

import com.rits.cloning.Cloner
import domain.Position
import domain.Text
import infrastructure.IImageHandler
import org.springframework.stereotype.Service
import java.awt.Graphics
import java.awt.image.BufferedImage

@Service
class ImageHandler : IImageHandler {
    override fun copyImage(image: BufferedImage): BufferedImage {
        val copiedImage = BufferedImage(image.width, image.height, image.type)
        val graphics = copiedImage.graphics
        graphics.drawImage(image, 0, 0, null)
        graphics.dispose()

        return copiedImage
    }

    override fun writeTextOnImageAtSpecificPosition(image: BufferedImage, position: Position, text: Text): BufferedImage {
        val graphicImage = image.createGraphics()
        graphicImage.font = text.font
        graphicImage.color = text.color
        graphicImage.drawString(text.label , position.x, position.y)

        return image;
    }
}
