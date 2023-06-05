package com.example.todolist.domain.image.presentation

import com.example.todolist.domain.image.usecase.ImageUpdateUseCase
import com.example.todolist.domain.image.usecase.ImageUploadUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageUploadUseCase: ImageUploadUseCase,
    private val imageUpdateUseCase: ImageUpdateUseCase
) {

    @PostMapping
    fun uploadImage(multipartFile: MultipartFile): ResponseEntity<String> =
        imageUploadUseCase.execute(multipartFile)
            .let { ResponseEntity.ok(it) }

    @PatchMapping
    fun updateImage(multipartFile: MultipartFile): ResponseEntity<Void> =
        imageUpdateUseCase.execute(multipartFile)
            .let { ResponseEntity.status(HttpStatus.RESET_CONTENT).build() }

}