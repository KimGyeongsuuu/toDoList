package com.example.todolist.domain.member.presentation.data.response

import java.util.*

data class MemberResponse(
    val idx: UUID,
    val email: String,
    val name: String
)
