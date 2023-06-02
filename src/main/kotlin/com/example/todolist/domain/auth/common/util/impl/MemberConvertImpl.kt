package com.example.todolist.domain.auth.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.auth.usecase.dto.TokenInDto
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.member.presentation.data.response.MemberResponse
import com.example.todolist.global.role.Role
import org.springframework.stereotype.Component
import java.util.*

@Component
class MemberConvertImpl : MemberConverter {

    override fun toSignUpDto(signUpRequest: SignUpRequest): SignUpDto =
        SignUpDto(
            idx = UUID.randomUUID(),
            email = signUpRequest.email,
            password = signUpRequest.password,
            name = signUpRequest.name,
            role = Role.MEMBER
        )

    override fun toSignInDto(signInRequest: SignInRequest): SignInDto =
        SignInDto(
            idx = UUID.randomUUID(),
            email = signInRequest.email,
            password = signInRequest.password,
            role = Role.MEMBER
        )

    override fun toMemberResponse(member: Member): MemberResponse =
        MemberResponse(
            idx = member.idx,
            email = member.email,
            name = member.name
        )

    override fun toTokenResponse(tokenInDto: TokenInDto): TokenResponse =
        TokenResponse(
            accessToken = tokenInDto.accessToken,
            refreshToken = tokenInDto.refreshToken,
            accessTokenExp = tokenInDto.accessTokenExp,
            refreshTokenExp = tokenInDto.refreshTokenExp
        )

    override fun toEntity(signUpDto: SignUpDto, encodePassword: String): Member =
        Member(
            idx = UUID.randomUUID(),
            email = signUpDto.email,
            password = encodePassword,
            name = signUpDto.name,
            profileImageUrl = null,
            role = Role.MEMBER
        )

}