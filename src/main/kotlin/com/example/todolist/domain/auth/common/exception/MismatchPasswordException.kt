package com.example.todolist.domain.auth.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoListException

class MismatchPasswordException : ToDoListException(ErrorCode.EXPIRATION_TOKEN)