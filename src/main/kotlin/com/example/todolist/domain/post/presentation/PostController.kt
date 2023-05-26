package com.example.todolist.domain.post.presentation

import com.example.todolist.domain.post.presentation.data.request.CreatePostRequest
import com.example.todolist.domain.post.presentation.data.response.PostResponse
import com.example.todolist.domain.post.usecase.CreatePostUseCase
import com.example.todolist.domain.post.usecase.GetPostUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class PostController(
    private val createPostUseCase: CreatePostUseCase,
    private val getPostUseCase: GetPostUseCase
) {
    @PostMapping
    fun createPost(@RequestBody @Valid createPostRequest: CreatePostRequest): ResponseEntity<Void> =
        createPostUseCase.execute(createPostRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getPost(): ResponseEntity<List<PostResponse>> =
        getPostUseCase.execute()
            .let { ResponseEntity.ok(it) }

}