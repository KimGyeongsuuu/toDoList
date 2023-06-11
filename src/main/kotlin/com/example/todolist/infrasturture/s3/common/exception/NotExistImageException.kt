package com.example.todolist.infrasturture.s3.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class NotExistImageException : ToDoException(ErrorCode.NOT_EXIST_IMAGE)