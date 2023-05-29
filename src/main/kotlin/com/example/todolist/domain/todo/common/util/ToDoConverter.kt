package com.example.todolist.domain.todo.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.DetailToDoResponse
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDetailDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDto
import com.example.todolist.domain.todo.usecase.dto.UpdateToDoDto

interface ToDoConverter {
    fun toToDoDto(toDo: ToDo, member: Member): ToDoDto
    fun toDetailToDoDto(toDo: ToDo, member: Member): ToDoDetailDto
    fun toToDoResponse(toDoDto: ToDoDto, member: Member): ToDoResponse
    fun toDetailToDoResponse(toDoDetailDto: ToDoDetailDto, member: Member): DetailToDoResponse
    fun toCreateToDoDto(toDoRequest: ToDoRequest): CreateToDoDto
    fun toUpdateToDoDto(toDoRequest: ToDoRequest): UpdateToDoDto
    fun toEntity(createToDoDto: CreateToDoDto, member: Member): ToDo
}