package com.example.todolist.domain.todolist.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.entity.repository.ToDoListRepository
import com.example.todolist.domain.todolist.usecase.dto.ToDoListDto
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction

@UseCaseWithReadOnlyTransaction
class GetToDoListUseCase(
    private val postRepository: ToDoListRepository,
    private val toDoListConverter: ToDoListConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(): List<ToDoListDto> =
        postRepository.findAll()
            .map { toDoListConverter.toToDoListDto(it, memberUtil.currentMember()) }

}