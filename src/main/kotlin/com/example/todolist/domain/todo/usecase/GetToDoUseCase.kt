package com.example.todolist.domain.todo.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.repository.ToDoRepository
import com.example.todolist.domain.todo.usecase.dto.ToDoDto
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction

@UseCaseWithReadOnlyTransaction
class GetToDoUseCase(
    private val postRepository: ToDoRepository,
    private val toDoConverter: ToDoConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(): List<ToDoDto> =
        postRepository.findAll()
            .map { toDoConverter.toToDoDto(it, memberUtil.currentMember()) }

}