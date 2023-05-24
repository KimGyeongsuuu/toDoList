package com.example.todolist.global.security.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoListException

class InvalidTokenException: ToDoListException(ErrorCode.INVALID_TOKEN)
