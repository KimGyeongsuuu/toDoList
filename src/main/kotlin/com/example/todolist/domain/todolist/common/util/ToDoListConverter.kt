package com.example.todolist.domain.todolist.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.member.presentation.data.response.MemberResponse
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse

interface ToDoListConverter {
    fun toEntity(toDoListRequest: ToDoListRequest, member: Member) : ToDoList
    fun toDto(toDoList: ToDoList, member: MemberResponse) : ToDoListResponse
}