package com.example.todolist.domain.todo.usecase.dto

import com.example.todolist.domain.member.entity.Member
import java.time.LocalDate

data class DetailToDoDto(
    val title: String,
    val content: String,
    val writer: Member,
    val date: LocalDate
)
