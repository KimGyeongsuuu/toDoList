package com.example.todolist.domain.auth.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class MismatchPasswordException : ToDoException(ErrorCode.MISMATCH_PASSWORD)