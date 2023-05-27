package com.example.todolist.domain.todolist.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import com.example.todolist.domain.todolist.usecase.dto.CreateToDoListDto
import com.example.todolist.domain.todolist.usecase.dto.ToDoListDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ToDoListConverterImpl(
    private val memberConverter: MemberConverter
) : ToDoListConverter {

    override fun toToDoListDto(toDoList: ToDoList, member: Member): ToDoListDto =
        ToDoListDto(
            title = toDoList.title,
            content = toDoList.content,
            writer = member
        )

    override fun toToDoListResponse(toDoListDto: ToDoListDto, member: Member): ToDoListResponse =
        ToDoListResponse(
            title = toDoListDto.title,
            content = toDoListDto.content,
            writer = memberConverter.toMemberResponse(member)
        )

    override fun toCreateToDoListDto(toDoListRequest: ToDoListRequest): CreateToDoListDto =
        CreateToDoListDto(
            title = toDoListRequest.title,
            content = toDoListRequest.content,
            date = toDoListRequest.date
        )

    override fun toEntity(createToDoListDto: CreateToDoListDto, member: Member): ToDoList =
        ToDoList(
            idx = UUID.randomUUID(),
            title = createToDoListDto.title,
            content = createToDoListDto.content,
            member = member,
            date = createToDoListDto.date
        )

}