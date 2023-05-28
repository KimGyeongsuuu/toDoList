package com.example.todolist.domain.todo.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class NotExistToDoListException : ToDoException(ErrorCode.NOT_EXIST_TODOLIST)