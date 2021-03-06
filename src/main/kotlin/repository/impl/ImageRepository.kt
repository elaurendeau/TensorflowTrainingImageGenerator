package repository.impl

import domain.FileRequest
import domain.Request
import domain.RestRequest
import infrastructure.IFileRequestHandler
import infrastructure.IRestRequestHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.IImageRepository
import java.awt.image.BufferedImage

@Service
class ImageRepository @Autowired constructor(val fileRequestHandler: IFileRequestHandler, val restRequestHandler: IRestRequestHandler) : IImageRepository {
    companion object {
        val EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE = "Invalid request type actual: %s"
    }

    override fun persist(request: Request, imageLabelPairList: List<Pair<BufferedImage, String>>) {
        when (request) {
            is FileRequest -> fileRequestHandler.persist(request, imageLabelPairList)
            is RestRequest -> restRequestHandler.send(request, imageLabelPairList)
            else -> throw IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE.format(request.javaClass.kotlin.toString()))
        }
    }
}