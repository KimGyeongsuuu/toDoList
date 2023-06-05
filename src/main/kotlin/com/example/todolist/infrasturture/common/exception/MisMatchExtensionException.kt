package com.example.todolist.infrasturture.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException


class MisMatchExtensionException : ToDoException(ErrorCode.MISMATCH_EXTENSION)