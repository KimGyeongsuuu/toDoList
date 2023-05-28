package com.example.todolist.domain.todo.presentation.data.response

import com.example.todolist.domain.member.presentation.data.response.MemberResponse

data class ToDoResponse(
    val title: String,
    val content: String,
    val writer: MemberResponse
)