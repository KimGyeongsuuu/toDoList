package com.example.todolist.domain.post.presentation.data.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class CreatePostRequest(
    @field:NotBlank
    val title:String,
    @field:NotBlank
    val content:String,
    val localDate: LocalDate
)
