package com.example.todolist.domain.todo.presentation

import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/todo")
class ToDoController(
    private val toDoConverter: ToDoConverter,
    private val createToDoUseCase: CreateToDoUseCase,
    private val getToDoUseCase: GetToDoUseCase,
    private val getDetailToDoUseCase: GetDetailToDoUseCase,
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase
) {

    @PostMapping
    fun createToDo(@RequestBody @Valid toDoRequest: ToDoRequest): ResponseEntity<Void> =
        toDoConverter.toCreateToDoDto(toDoRequest)
            .let { createToDoUseCase.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getToDo(): ResponseEntity<List<ToDoResponse>> =
        getToDoUseCase.execute()
            .map { toDoConverter.toToDoResponse(it, it.writer) }
            .let { ResponseEntity.ok(it) }

    @GetMapping("/{idx}")
    fun getDetailToDo(@PathVariable idx: UUID): ResponseEntity<ToDoResponse> =
        getDetailToDoUseCase.execute(idx)
            .let { toDoConverter.toToDoResponse(it, it.writer) }
            .let { ResponseEntity.ok(it) }

    @PatchMapping("/{idx}")
    fun updateToDo(@PathVariable idx: UUID, @RequestBody @Valid toDoRequest: ToDoRequest): ResponseEntity<Void> =
        toDoConverter.toUpdateToDoDto(toDoRequest)
            .let { updateToDoUseCase.execute(idx, it) }
            .let { ResponseEntity.status(HttpStatus.RESET_CONTENT).build() }

    @DeleteMapping("/{idx}")
    fun deleteToDo(@PathVariable idx: UUID): ResponseEntity<Void> =
        deleteToDoUseCase.execute(idx)
            .let { ResponseEntity.status(HttpStatus.RESET_CONTENT).build() }

}