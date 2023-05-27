package com.example.todolist.domain.todolist.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class ToDoListConverterImpl(
    private val memberConverter: MemberConverter
) : ToDoListConverter{

    override fun toToDoListResponse(toDoList: ToDoList, member: Member): ToDoListResponse =
        ToDoListResponse(
            title = toDoList.title,
            content = toDoList.content,
            writer = memberConverter.toMemberResponse(member)
        )

    override fun toEntity(toDoListRequest: ToDoListRequest, member: Member): ToDoList =
        ToDoList(
            idx = UUID.randomUUID(),
            title = toDoListRequest.title,
            content = toDoListRequest.content,
            member = member,
            date = toDoListRequest.date
        )

}