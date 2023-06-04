package com.example.todolist.domain.image.usecase

import org.springframework.web.multipart.MultipartFile

interface UploadImageUseCase {
    fun execute(multipartFile: MultipartFile): String
}