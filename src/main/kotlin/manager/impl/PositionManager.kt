package manager.impl

import domain.Position
import domain.Text
import manager.IPositionManager
import org.springframework.stereotype.Service
import java.util.concurrent.ThreadLocalRandom

@Service
class PositionManager : IPositionManager {
    companion object {
        val EXCEPTION_MESSAGE_TEXT_TOO_BIG = "Label can't be bigger than the canvas"
    }

    override fun generateRandomPosition(text: Text, sizeX: Int, sizeY: Int): Position {
        val textSizeX = text.label.length * text.font.size
        val textSizeY = 1 * text.font.size


        if (textSizeX > sizeX || textSizeY > sizeY) {
            throw IllegalArgumentException(EXCEPTION_MESSAGE_TEXT_TOO_BIG)
        }

        val possibleDistanceX = sizeX - textSizeX
        val possibleDistanceY = sizeY - textSizeY

        return Position(ThreadLocalRandom.current().nextInt(0, possibleDistanceX), ThreadLocalRandom.current().nextInt(textSizeY, possibleDistanceY))
    }
}