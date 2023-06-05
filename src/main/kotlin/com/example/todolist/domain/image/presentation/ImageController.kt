package com.example.todolist.domain.image.presentation

import com.example.todolist.domain.image.usecase.ImageUploadUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageUploadUseCase: ImageUploadUseCase
) {

    @PostMapping
    fun uploadImage(multipartFile: MultipartFile): ResponseEntity<String> =
        imageUploadUseCase.execute(multipartFile)
            .let { ResponseEntity.ok(it) }

}