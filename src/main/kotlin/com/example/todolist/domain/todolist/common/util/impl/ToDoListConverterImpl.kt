package com.example.todolist.domain.todolist.common.util.impl

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.member.presentation.data.response.MemberResponse
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.ToDoList
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class ToDoListConverterImpl(

) : ToDoListConverter{
    override fun toEntity(toDoListRequest: ToDoListRequest, member: Member): ToDoList =
        ToDoList(
            idx = UUID.randomUUID(),
            title = toDoListRequest.title,
            content = toDoListRequest.content,
            member = member,
            localDate = toDoListRequest.localDate
        )

    override fun toDto(toDoList: ToDoList, member: MemberResponse): ToDoListResponse =
        ToDoListResponse(
            title = toDoList.title,
            content = toDoList.content,
            member = member
        )


}