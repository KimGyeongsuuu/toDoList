package com.example.todolist.global.security.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class InvalidTokenException : ToDoException(ErrorCode.INVALID_TOKEN)
