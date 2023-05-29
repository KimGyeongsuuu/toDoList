package com.example.todolist.domain.todo.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.DetailToDoResponse
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDetailDto
import com.example.todolist.domain.todo.usecase.dto.ToDoDto
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
            writer = member
        )

    override fun toDetailToDoDto(toDo: ToDo, member: Member): ToDoDetailDto =
        ToDoDetailDto(
            title = toDo.title,
            content = toDo.content,
            writer = toDo.member,
            date = toDo.date
        )

    override fun toToDoResponse(toDoDto: ToDoDto, member: Member): ToDoResponse =
        ToDoResponse(
            title = toDoDto.title,
            content = toDoDto.content,
            writer = memberConverter.toMemberResponse(member)
        )

    override fun toDetailToDoResponse(toDoDetailDto: ToDoDetailDto, member: Member): DetailToDoResponse =
        DetailToDoResponse(
            title = toDoDetailDto.title,
            content = toDoDetailDto.content,
            writer = memberConverter.toMemberResponse(toDoDetailDto.writer),
            date = toDoDetailDto.date
        )

    override fun toCreateToDoDto(toDoRequest: ToDoRequest): CreateToDoDto =
        CreateToDoDto(
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