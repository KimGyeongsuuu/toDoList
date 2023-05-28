package com.example.todolist.global.error.handler

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.ErrorResponse
import com.example.todolist.global.error.exceptions.ToDoException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    @ExceptionHandler(ToDoException::class)
    fun globalExceptionHandler(request: HttpServletRequest, e: ToDoException): ResponseEntity<ErrorResponse> {
        log.error(e.errorCode.message)
        log.error(request.requestURI)
        val errorCode: ErrorCode = e.errorCode
        return ResponseEntity(
            ErrorResponse(status = errorCode.status, message = errorCode.message),
            HttpStatus.valueOf(errorCode.status)
        )
    }

}