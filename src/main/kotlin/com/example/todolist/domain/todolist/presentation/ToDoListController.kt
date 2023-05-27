package com.example.todolist.domain.todolist.presentation

import com.example.todolist.domain.todolist.presentation.data.request.ToDoListRequest
import com.example.todolist.domain.todolist.presentation.data.response.ToDoListResponse
import com.example.todolist.domain.todolist.usecase.CreateToDoListUseCase
import com.example.todolist.domain.todolist.usecase.GetToDoListUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/todolist")
class ToDoListController(
    private val createToDoListUseCase: CreateToDoListUseCase,
    private val getToDoListUseCase: GetToDoListUseCase
) {
    @PostMapping
    fun createPost(@RequestBody @Valid toDoListRequest: ToDoListRequest): ResponseEntity<Void> =
        createToDoListUseCase.execute(toDoListRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getPost(): ResponseEntity<List<ToDoListResponse>> =
        getToDoListUseCase.execute()
            .let { ResponseEntity.ok(it) }

}