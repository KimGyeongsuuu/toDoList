package com.example.todolist.domain.todolist.presentation.data.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class ToDoListRequest(
    @field:NotBlank
    val title:String,
    @field:NotBlank
    val content:String,
    val localDate: LocalDate
)
