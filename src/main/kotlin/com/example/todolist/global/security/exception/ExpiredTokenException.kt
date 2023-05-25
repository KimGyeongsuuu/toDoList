package com.example.todolist.global.security.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoListException

class ExpiredTokenException : ToDoListException(ErrorCode.EXPIRATION_TOKEN)