package com.example.todolist.domain.auth.common.util

import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.usecase.dto.MemberDto
import com.example.todolist.domain.member.entity.Member


interface AccountConverter {
    fun toDto(signUpRequest: SignUpRequest) : MemberDto
    fun toDto(signInRequest: SignInRequest) : MemberDto
    fun toEntity(memberDto: MemberDto, encodePassword : String) : Member
}