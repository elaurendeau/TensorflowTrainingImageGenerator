package manager

import domain.Position
import domain.Text

interface IPositionManager {
    fun generateRandomPosition(text: Text, sizeX: Int, sizeY: Int): Position
}