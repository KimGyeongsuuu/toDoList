package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.MismatchPasswordException
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.TokenInDto
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

    fun execute(signInDto: SignInDto) : TokenInDto =
        validateLogin(signInDto.email, signInDto.password)
            .let { jwtGenerator.generateToken(signInDto.email,signInDto.role) }

    private fun validateLogin(email : String, password : String) {
        memberRepository.findByEmail(email)
            .let { it ?: throw MemberNotFoundException() }
            .let { passwordEncoder.matches(password, it.password) }
            .let { if (it) return else throw MismatchPasswordException() }
    }

}