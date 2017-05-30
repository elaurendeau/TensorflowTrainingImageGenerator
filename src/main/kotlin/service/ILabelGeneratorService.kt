package service

import domain.Request
import java.awt.image.BufferedImage

interface ILabelGeneratorService {
    /**
     * Generate pairs of label and position to print on an image. The list should contain multiple font and color as well.
     *
     * @param regex {@link String}
     * @param sizeX {@link Int} length of the canvas
     * @param sizeY {@link Int} height of the canvas
     * @param occurrence {@link Int} number of occurrence. 0 means all occurrences
     *
     * @return {@link List}<{@link Pair}<{@link Text}, {@link Position}>>
     */
    fun generateLabelByRegexAndCanvasDimension(image: BufferedImage, regex: String, sizeX: Int, sizeY: Int, occurrence: Int, path: String, request: Request): Unit
}