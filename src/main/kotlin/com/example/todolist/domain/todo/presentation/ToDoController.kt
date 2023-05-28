package com.example.todolist.domain.todo.presentation

import com.example.todolist.domain.todo.common.util.ToDoConverter
import com.example.todolist.domain.todo.presentation.data.request.ToDoRequest
import com.example.todolist.domain.todo.presentation.data.response.ToDoResponse
import com.example.todolist.domain.todo.usecase.CreateToDoUseCase
import com.example.todolist.domain.todo.usecase.GetToDoUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/todolist")
class ToDoController(
    private val createToDoUseCase: CreateToDoUseCase,
    private val getToDoUseCase: GetToDoUseCase,
    private val toDoConverter: ToDoConverter,
) {

    @PostMapping
    fun createPost(@RequestBody @Valid toDoRequest: ToDoRequest): ResponseEntity<Void> =
        toDoConverter.toCreateToDoDto(toDoRequest)
            .let { createToDoUseCase.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getPost(): ResponseEntity<List<ToDoResponse>> =
        getToDoUseCase.execute()
            .map { toDoConverter.toToDoResponse(it,it.writer) }
            .let { ResponseEntity.ok(it) }

}