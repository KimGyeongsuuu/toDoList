package com.example.todolist.domain.todo.presentation.data.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class ToDoRequest(
    @field:NotBlank
    val title: String,
    @field:NotBlank
    val content: String,
    val date: LocalDate
)
