package com.example.todolist.domain.todo.entity.repository

import com.example.todolist.domain.todo.entity.ToDo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ToDoRepository : JpaRepository<ToDo, UUID> {
    fun findByIdx(idx: UUID) : ToDo?
}