package com.example.todolist.domain.post.presentation

import com.example.todolist.domain.post.presentation.data.request.CreatePostRequest
import com.example.todolist.domain.post.usecase.CreatePostUsecase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class PostController(
    private val createPostUsecase: CreatePostUsecase
) {

    @PostMapping
    fun createPost(@RequestBody @Valid createPostRequest: CreatePostRequest) : ResponseEntity<Void> {
        createPostUsecase.execute(createPostRequest)
            .let { return ResponseEntity.status(HttpStatus.CREATED).build() }
    }

}