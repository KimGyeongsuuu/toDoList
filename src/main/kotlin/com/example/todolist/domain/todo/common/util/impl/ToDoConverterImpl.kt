package com.example.todolist.domain.todo.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ToDoConverterImpl(
    private val memberConverter: MemberConverter
) : ToDoConverter {

    override fun toToDoDto(toDoList: ToDo, member: Member): ToDoDto =
        ToDoDto(
            title = toDoList.title,
            content = toDoList.content,
            writer = member
        )

    override fun toToDoResponse(toDoListDto: ToDoDto, member: Member): ToDoResponse =
        ToDoResponse(
            title = toDoListDto.title,
            content = toDoListDto.content,
            writer = memberConverter.toMemberResponse(member)
        )

    override fun toCreateToDoDto(toDoListRequest: ToDoRequest): CreateToDoDto =
        CreateToDoDto(
            title = toDoListRequest.title,
            content = toDoListRequest.content,
            date = toDoListRequest.date
        )

    override fun toEntity(createToDoListDto: CreateToDoDto, member: Member): ToDo =
        ToDo(
            idx = UUID.randomUUID(),
            title = createToDoListDto.title,
            content = createToDoListDto.content,
            member = member,
            date = createToDoListDto.date
        )

}