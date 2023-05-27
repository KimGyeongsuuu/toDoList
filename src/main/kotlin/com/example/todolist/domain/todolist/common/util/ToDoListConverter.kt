package com.example.todolist.domain.todolist.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import com.example.todolist.domain.todolist.usecase.dto.CreateToDoListDto
import com.example.todolist.domain.todolist.usecase.dto.ToDoListDto

interface ToDoListConverter {
    fun toToDoListDto(toDoList: ToDoList, member: Member): ToDoListDto
    fun toToDoListResponse(toDoListDto: ToDoListDto, member: Member): ToDoListResponse
    fun toCreateToDoListDto(toDoListRequest: ToDoListRequest): CreateToDoListDto
    fun toEntity(createToDoListDto: CreateToDoListDto, member: Member): ToDoList
}