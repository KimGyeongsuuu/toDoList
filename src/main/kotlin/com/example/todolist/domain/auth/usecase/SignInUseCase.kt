package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.MismatchPasswordException
import com.example.todolist.domain.auth.usecase.dto.SignInDto
import com.example.todolist.domain.auth.usecase.dto.TokenInDto
import com.example.todolist.domain.member.common.exception.MemberNotFoundException
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder

@UseCaseWithTransaction
class SignInUseCase(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(signInDto: SignInDto): TokenInDto {
        val member = memberRepository.findByEmail(signInDto.email) ?: throw MemberNotFoundException()
        passwordEncoder.matches(signInDto.password, member.password)
            .let {
                if (it)
                    return jwtGenerator.generateToken(signInDto.email, signInDto.role)
                else
                    throw MismatchPasswordException()
            }
    }

}