package com.example.todolist.domain.todolist.presentation.data.response

import com.example.todolist.domain.member.presentation.data.response.MemberResponse

data class ToDoListResponse(
    val title:String,
    val content:String,
    val member: MemberResponse
)
