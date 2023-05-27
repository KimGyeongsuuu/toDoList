package com.example.todolist.domain.todolist.usecase.dto

import java.time.LocalDate

data class CreateToDoListDto(
    val title: String,
    val content: String,
    val date: LocalDate
)
