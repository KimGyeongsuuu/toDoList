package com.example.todolist.global.annotation

import org.springframework.transaction.annotation.Transactional

@Target(AnnotationTarget.CLASS)
@Transactional(rollbackFor = [Exception::class])
annotation class UseCaseWithTransaction