package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.DuplicateEmailException
import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.security.crypto.password.PasswordEncoder

@UseCaseWithTransaction
class SignUpUseCase(
    private val passwordEncoder: PasswordEncoder,
    private val memberRepository: MemberRepository,
    private val memberConverter: MemberConverter
) {

    fun execute(signUpDto: SignUpDto) {
        if (memberRepository.existsByEmail(signUpDto.email)) {
            throw DuplicateEmailException()
        }
        memberConverter.toEntity(signUpDto, passwordEncoder.encode(signUpDto.password))
            .let { memberRepository.save(it) }
    }

}