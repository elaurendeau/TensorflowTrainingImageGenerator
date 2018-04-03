package domain

data class FileRequest(val path: String, val saveImages: Boolean) : Request()
