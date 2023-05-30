package com.example.todolist.domain.todo.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDto
import com.example.todolist.domain.todo.usecase.dto.UpdateToDoDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ToDoConverterImpl(
    private val memberConverter: MemberConverter
) : ToDoConverter {

    override fun toToDoDto(toDo: ToDo, member: Member): ToDoDto =
        ToDoDto(
            title = toDo.title,
            content = toDo.content,
            writer = member,
            date = toDo.date
        )

    override fun toToDoResponse(toDoDto: ToDoDto, member: Member): ToDoResponse =
        ToDoResponse(
            title = toDoDto.title,
            content = toDoDto.content,
            writer = memberConverter.toMemberResponse(member),
            date = toDoDto.date
        )

    override fun toCreateToDoDto(toDoRequest: ToDoRequest): CreateToDoDto =
        CreateToDoDto(
            title = toDoRequest.title,
            content = toDoRequest.content,
            date = toDoRequest.date
        )

    override fun toUpdateToDoDto(toDoRequest: ToDoRequest): UpdateToDoDto =
        UpdateToDoDto(
            title = toDoRequest.title,
            content = toDoRequest.content,
            date = toDoRequest.date
        )

    override fun toEntity(createToDoDto: CreateToDoDto, member: Member): ToDo =
        ToDo(
            idx = UUID.randomUUID(),
            title = createToDoDto.title,
            content = createToDoDto.content,
            member = member,
            date = createToDoDto.date
        )

}