package dto

import domain.Request

data class ImageTestResultRequest(val imagePath: String, val regex: String, val occurrence: Int, val batchSize: Int, val request: Request)