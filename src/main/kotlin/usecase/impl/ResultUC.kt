package usecase.impl

import domain.poco.Text
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import usecase.IResultUC
import java.awt.image.BufferedImage

@Service
class ResultUC @Autowired constructor(): IResultUC{
    override fun generateResult(imageTextList: List<Pair<BufferedImage, Text>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}