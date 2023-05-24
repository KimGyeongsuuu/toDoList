package com.example.todolist.domain.auth.common.util.impl

import com.example.todolist.domain.auth.common.util.AccountConverter
import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.usecase.dto.MemberDto
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.global.role.Role
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountConvertImpl : AccountConverter {
    override fun toDto(signUpRequest: SignUpRequest): MemberDto =
        MemberDto(
            idx = UUID.randomUUID(),
            email = signUpRequest.email,
            password = signUpRequest.password,
            name = signUpRequest.name,
            role = Role.MEMBER
        )

    override fun toDto(signInRequest: SignInRequest): MemberDto =
        MemberDto(
            idx = UUID.randomUUID(),
            email = signInRequest.email,
            password = signInRequest.password,
            name = "",
            role = Role.MEMBER
        )
    override fun toEntity(memberDto: MemberDto, encodePassword: String): Member =
        Member(
            idx = UUID.randomUUID(),
            email = memberDto.email,
            password = encodePassword,
            name = memberDto.name,
            role = Role.MEMBER
        )
}