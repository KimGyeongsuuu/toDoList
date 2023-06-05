package com.example.todolist.domain.image.usecase

import org.springframework.web.multipart.MultipartFile

interface ImageUploadUseCase {
    fun execute(multipartFile: MultipartFile): String
}