package com.example.todolist.global.security.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class ExpiredTokenException : ToDoException(ErrorCode.EXPIRATION_TOKEN)