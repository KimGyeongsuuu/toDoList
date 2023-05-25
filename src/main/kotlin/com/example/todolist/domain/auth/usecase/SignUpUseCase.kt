package com.example.todolist.domain.auth.usecase

import com.example.todolist.domain.auth.common.exception.DuplicateEmailException
import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.auth.usecase.dto.SignUpDto
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
@UseCaseWithTransaction
class SignUpUseCase(
    private val passwordEncoder: PasswordEncoder,
    private val memberRepository: MemberRepository,
    private val accountConverter: MemberConverter
) {

    fun execute(signUpDto: SignUpDto) {
        if (memberRepository.existsByEmail(signUpDto.email)) {
            throw DuplicateEmailException()
        }
        accountConverter.toEntity(signUpDto, passwordEncoder.encode(signUpDto.password))
            .let { memberRepository.save(it) }
    }

}