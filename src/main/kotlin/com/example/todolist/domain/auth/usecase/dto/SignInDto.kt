package com.example.todolist.domain.auth.usecase.dto

import com.example.todolist.global.role.Role
import java.util.UUID

data class SignInDto(
    val idx: UUID,
    val email: String,
    val password: String,
    val role: Role
)
