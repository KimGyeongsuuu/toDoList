package com.example.todolist.domain.image.presentation

import com.example.todolist.domain.image.usecase.UploadImageUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController(
    private val uploadImageUseCase: UploadImageUseCase
) {

    @PostMapping
    fun uploadImage(multipartFiles: MultipartFile): ResponseEntity<String> =
        uploadImageUseCase.execute(multipartFiles)
            .let { ResponseEntity.ok(it) }

}