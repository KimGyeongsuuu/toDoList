package com.example.todolist.domain.todolist.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.repository.ToDoListRepository
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.global.annotation.UseCaseWithTransaction

@UseCaseWithTransaction
class CreateToDoListUseCase(
    private val postRepository: ToDoListRepository,
    private val toDoListConverter: ToDoListConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(toDoListRequest: ToDoListRequest) {
        postRepository.save(toDoListConverter.toEntity(toDoListRequest, memberUtil.currentMember()))
    }

}