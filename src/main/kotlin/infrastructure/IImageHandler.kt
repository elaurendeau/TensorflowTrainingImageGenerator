package infrastructure


import domain.poco.Position
import domain.poco.Text
import java.awt.image.BufferedImage

/**
 * This interface declares the different methods used to handle images
 */
interface IImageHandler {

    /**
     * Write a specific string on a {@link BufferedImage} at a given {@link Position}
     *
     * @param image {@link BufferedImage}
     * @param position {@link Position} of the future text
     * @param text {@link Text} to type on the image
     *
     * @return {@link BufferedImage}
     */
    fun writeTextOnImageAtSpecificPosition(image: BufferedImage, position: Position, text: Text): BufferedImage
}

