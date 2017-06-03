package dto

data class ImageTestResultRequest(val imagePath: String, val regex: String, val occurrence: Int, val callbackUrl: String)