package `interface`.controller.impl

import `interface`.controller.IRequestRepository
import `interface`.controller.poco.FileRequest
import `interface`.controller.poco.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestRepository @Autowired constructor(): IRequestRepository{

    companion object {
        val EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE = "Invalid request type actual: %s"
    }
    override fun persist(request: Request) {
        when(request) {
            is FileRequest -> TODO()
            else -> throw IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_REQUEST_TYPE.format(request.javaClass.kotlin.toString()))
        }
    }
}