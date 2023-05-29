package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.entity.repository.RefreshTokenRepository
import com.example.todolist.domain.auth.usecase.dto.TokenInDto
import com.example.todolist.domain.member.common.exception.MemberNotFoundException
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.global.security.exception.ExpiredTokenException
import com.example.todolist.global.security.exception.InvalidTokenException
import com.example.todolist.global.security.jwt.JwtGenerator
import com.example.todolist.global.security.jwt.JwtParser
import org.springframework.data.repository.findByIdOrNull

@UseCaseWithTransaction
class ReissueTokenUseCase(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val memberRepository: MemberRepository,
    private val jwtParser: JwtParser,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(refreshToken: String): TokenInDto {
        val parsedRefreshToken = jwtParser.parseRefreshToken(refreshToken) ?: throw InvalidTokenException()
        val refreshToken = refreshTokenRepository.findByIdOrNull(parsedRefreshToken) ?: throw ExpiredTokenException()
        val member = memberRepository.findByEmail(refreshToken.email) ?: throw MemberNotFoundException()

        return jwtGenerator.generateToken(member.email, member.role)
    }

}