package com.example.todolist.global.error.exceptions

import com.example.todolist.global.error.ErrorCode

open class ToDoException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)
