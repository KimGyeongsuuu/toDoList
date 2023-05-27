package com.example.todolist.domain.todolist.usecase.dto

import com.example.todolist.domain.member.entity.Member

data class ToDoListDto(
    val title: String,
    val content: String,
    val writer: Member
)
