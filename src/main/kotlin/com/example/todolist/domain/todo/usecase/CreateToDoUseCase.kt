package com.example.todolist.domain.todo.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.repository.ToDoRepository
import com.example.todolist.domain.todo.usecase.dto.CreateToDoDto
import com.example.todolist.global.annotation.UseCaseWithTransaction

@UseCaseWithTransaction
class CreateToDoUseCase(
    private val postRepository: ToDoRepository,
    private val toDoConverter: ToDoConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(createToDoDto: CreateToDoDto) {
        postRepository.save(toDoConverter.toEntity(createToDoDto, memberUtil.currentMember()))
    }

}