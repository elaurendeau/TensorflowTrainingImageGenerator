package `interface`.controller

import `interface`.controller.poco.Request

interface IRequestRepository {
    fun persist(request: Request)
}