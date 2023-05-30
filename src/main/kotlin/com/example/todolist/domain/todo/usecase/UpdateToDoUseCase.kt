package com.example.todolist.domain.todo.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.member.common.exception.NotVerifyMemberException
import com.example.todolist.domain.todo.common.exception.NotExistToDoListException
import com.example.todolist.domain.todo.entity.ToDo
import com.example.todolist.domain.todo.entity.repository.ToDoRepository
import com.example.todolist.domain.todo.usecase.dto.UpdateToDoDto
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@UseCaseWithTransaction
class UpdateToDoUseCase(
    private val toDoRepository: ToDoRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(idx: UUID, updateToDoDto: UpdateToDoDto) {
        toDoRepository.findByIdOrNull(idx)
            .let { it ?: throw NotExistToDoListException() }
            .let { verifyMember(it) }
            .let { it.updateToDo(updateToDoDto.title,updateToDoDto.content,updateToDoDto.date) }
    }

    private fun verifyMember(toDo: ToDo): ToDo {
        if (!memberUtil.currentMember().equals(toDo.member)) {
            throw NotVerifyMemberException()
        }
        return toDo
    }

}