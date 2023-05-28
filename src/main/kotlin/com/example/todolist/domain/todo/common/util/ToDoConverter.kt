package com.example.todolist.domain.todo.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDto

interface ToDoConverter {
    fun toToDoDto(toDoList: ToDo, member: Member): ToDoDto
    fun toToDoResponse(toDoListDto: ToDoDto, member: Member): ToDoResponse
    fun toCreateToDoDto(toDoListRequest: ToDoRequest): CreateToDoDto
    fun toEntity(createToDoListDto: CreateToDoDto, member: Member): ToDo
}