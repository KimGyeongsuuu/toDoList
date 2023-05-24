package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.MismatchPasswordException
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.dto.MemberDto
import com.example.todolist.domain.member.common.exception.MemberNotFoundException
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.global.security.jwt.JwtGenerator
import com.example.todolist.global.security.jwt.JwtParser
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@UseCaseWithTransaction
class SignInUseCase (
    private val memberRepository : MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(memberDto: MemberDto) : TokenResponse =
        validateLogin(memberDto)
            .let { jwtGenerator.generateToken(memberDto.email,memberDto.role) }


    private fun validateLogin(memberDto: MemberDto) {
        memberRepository.findByEmail(memberDto.email)
            .let { it ?: throw MemberNotFoundException() }
            .let { passwordEncoder.matches(memberDto.password, it.password) }
            .let {
                if (it)
                    return
                else throw MismatchPasswordException()
            }
    }
}