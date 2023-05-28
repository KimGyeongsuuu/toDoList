package com.example.todolist.domain.todo.presentation.data.response

import com.example.todolist.domain.member.presentation.data.response.MemberResponse
import java.time.LocalDate

data class DetailToDoResponse(
    val title: String,
    val content: String,
    val writer: MemberResponse,
    val date: LocalDate
)
