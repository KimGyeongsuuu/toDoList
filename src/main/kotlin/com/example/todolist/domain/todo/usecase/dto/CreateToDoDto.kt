package com.example.todolist.domain.todo.usecase.dto

import java.time.LocalDate

data class CreateToDoDto(
    val title: String,
    val content: String,
    val date: LocalDate
)
