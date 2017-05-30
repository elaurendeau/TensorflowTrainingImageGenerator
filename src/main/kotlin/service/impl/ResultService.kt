package service.impl

import domain.Request
import domain.Text
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.IImageRepository
import service.IResultService
import java.awt.image.BufferedImage

@Service
class ResultService @Autowired constructor(val imageRepository: IImageRepository) : IResultService {
    override fun generateResult(request: Request, imageTextList: List<Pair<BufferedImage, Text>>) {
        imageTextList.forEach {
            imageRepository.persist(request, it.first, it.second.label)
        }
    }
}