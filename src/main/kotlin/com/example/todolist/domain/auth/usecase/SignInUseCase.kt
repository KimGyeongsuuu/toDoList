package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.MismatchPasswordException
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.member.common.exception.MemberNotFoundException
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@UseCaseWithTransaction
class SignInUseCase (
    private val memberRepository : MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(signInDto: SignInDto) : TokenResponse =
        validateLogin(signInDto)
            .let { jwtGenerator.generateToken(signInDto.email,signInDto.role) }


    private fun validateLogin(signInDto: SignInDto) {
        memberRepository.findByEmail(signInDto.email)
            .let { it ?: throw MemberNotFoundException() }
            .let { passwordEncoder.matches(signInDto.password, it.password) }
            .let { if (it) return else throw MismatchPasswordException() }
    }

}