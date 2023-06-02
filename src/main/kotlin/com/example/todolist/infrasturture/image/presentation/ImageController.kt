package com.example.todolist.infrasturture.image.presentation

import com.example.todolist.infrasturture.image.usecase.UploadImageUseCase
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
    fun uploadProfileImg(multipartFiles: MultipartFile): ResponseEntity<List<String>> {
        uploadImageUseCase.execute(multipartFiles)
            .let { return ResponseEntity.ok(it) }
    }

}