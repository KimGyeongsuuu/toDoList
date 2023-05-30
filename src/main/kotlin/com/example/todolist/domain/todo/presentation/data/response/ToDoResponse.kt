package com.example.todolist.domain.todo.presentation.data.response

import java.time.LocalDate

data class ToDoResponse(
    val title: String,
    val content: String,
    val date: LocalDate
)
