package com.example.todolist.domain.todolist.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse

interface ToDoListConverter {
    fun toToDoListResponse(toDoList: ToDoList, member: Member): ToDoListResponse
    fun toEntity(toDoListRequest: ToDoListRequest, member: Member): ToDoList
}