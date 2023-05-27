package com.example.todolist.domain.todolist.entity.repository

import com.example.todolist.domain.todolist.entity.ToDoList
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ToDoListRepository : JpaRepository<ToDoList, UUID>