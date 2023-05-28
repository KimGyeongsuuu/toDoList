package com.example.todolist.domain.todo.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.todo.common.exception.NotExistToDoListException
import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.entity.repository.ToDoRepository
import com.example.todolist.domain.todo.usecase.dto.DetailToDoDto
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction
import java.util.*

@UseCaseWithReadOnlyTransaction
class GetDetailToDoUseCase (
    private val toDoRepository: ToDoRepository,
    private val toDoConverter: ToDoConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(idx: UUID): DetailToDoDto =
        toDoRepository.findByIdx(idx)
            .let { it ?: throw NotExistToDoListException() }
            .let { toDoConverter.toDetailToDoDto(it, memberUtil.currentMember()) }

}