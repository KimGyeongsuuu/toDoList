package com.example.todolist.domain.auth.usecase.dto

import com.example.todolist.global.role.Role
import java.util.UUID

data class MemberDto(
    val idx: UUID,
    val email: String,
    val password: String,
    val name: String,
    val role: Role
)
