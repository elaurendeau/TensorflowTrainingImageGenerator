package usecase.impl

import domain.poco.Position
import domain.poco.Text
import usecase.ILabelGeneratorUC

class LabelGeneratorUC: ILabelGeneratorUC {
    override fun writeOnImage(regex: String, positionX: Int, positionY: Int): List<Pair<Text, Position>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


