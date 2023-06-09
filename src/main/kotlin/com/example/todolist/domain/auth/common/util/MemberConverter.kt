package com.example.todolist.domain.auth.common.util

import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.auth.usecase.dto.TokenInDto
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.member.presentation.data.response.MemberResponse


interface MemberConverter {
    fun toSignUpDto(signUpRequest: SignUpRequest): SignUpDto
    fun toSignInDto(signInRequest: SignInRequest): SignInDto
    fun toMemberResponse(member: Member): MemberResponse
    fun toTokenResponse(tokenInDto: TokenInDto): TokenResponse
    fun toEntity(signUpDto: SignUpDto, encodePassword: String): Member
}