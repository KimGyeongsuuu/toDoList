package com.example.todolist.domain.todolist.usecase

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.repository.ToDoListRepository
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction


@UseCaseWithReadOnlyTransaction
class GetToDoListUseCase(
    private val postRepository: ToDoListRepository,
    private val memberUtil: MemberUtil,
    private val memberConverter: MemberConverter,
    private val toDoListConverter: ToDoListConverter
) {
    fun execute() : List<ToDoListResponse> =
        postRepository.findAll()
            .map { toDoListConverter.toDto(it, memberConverter.toMemberResponse(memberUtil.currentMember())) }

}