package com.example.todolist.global.annotation

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Target(AnnotationTarget.CLASS)
@Transactional(rollbackFor = [Exception::class])
annotation class UseCaseWithTransaction