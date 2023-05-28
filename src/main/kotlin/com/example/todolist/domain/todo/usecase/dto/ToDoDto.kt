package com.example.todolist.domain.todo.usecase.dto

import com.example.todolist.domain.member.entity.Member

data class ToDoDto(
    val title: String,
    val content: String,
    val writer: Member
)
