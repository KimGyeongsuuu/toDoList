package com.example.todolist.domain.auth.common.util

import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.member.entity.Member


interface AccountConverter {
    fun toDto(signUpRequest: SignUpRequest) : SignUpDto
    fun toDto(signInRequest: SignInRequest) : SignInDto
    fun toEntity(signUpDto: SignUpDto, encodePassword : String) : Member
}