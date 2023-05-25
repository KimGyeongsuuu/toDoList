package com.example.todolist.global.error.exceptions

import com.example.todolist.global.error.ErrorCode

open class ToDoListException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)
