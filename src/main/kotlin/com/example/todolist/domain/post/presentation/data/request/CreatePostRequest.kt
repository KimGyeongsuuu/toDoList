package com.example.todolist.domain.post.presentation.data.request

import javax.validation.constraints.NotBlank

data class CreatePostRequest(
    @field:NotBlank
    val title:String,
    @field:NotBlank
    val content:String
)
