package com.example.todolist.domain.todolist.presentation

import com.example.todolist.domain.todolist.common.util.ToDoListConverter
import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import com.example.todolist.domain.todolist.usecase.CreateToDoListUseCase
import com.example.todolist.domain.todolist.usecase.GetToDoListUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/todolist")
class ToDoListController(
    private val createToDoListUseCase: CreateToDoListUseCase,
    private val getToDoListUseCase: GetToDoListUseCase,
    private val toDoListConverter: ToDoListConverter,
) {

    @PostMapping
    fun createPost(@RequestBody @Valid toDoListRequest: ToDoListRequest): ResponseEntity<Void> =
        toDoListConverter.toCreateToDoListDto(toDoListRequest)
            .let { createToDoListUseCase.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getPost(): ResponseEntity<List<ToDoListResponse>> =
        getToDoListUseCase.execute()
            .map { toDoListConverter.toToDoListResponse(it,it.writer) }
            .let { ResponseEntity.ok(it) }

}