package com.example.todolist.domain.image.usecase

import org.springframework.web.multipart.MultipartFile

interface ImageUpdateUseCase {
    fun execute(multipartFile: MultipartFile)
}