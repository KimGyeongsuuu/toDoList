package com.example.todolist.domain.auth.common.util.impl

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.member.common.exception.MemberNotFoundException
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.member.entity.repository.MemberRepository
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction
import com.example.todolist.global.security.auth.MemberDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
@UseCaseWithReadOnlyTransaction
class MemberUtilImpl(
    private val memberRepository: MemberRepository
) : MemberUtil {

    override fun currentMember(): Member {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val email = if (principal is UserDetails) {
            (principal as MemberDetails).username
        } else {
            principal.toString()
        }
        return findMemberByEmail(email)
    }

    private fun findMemberByEmail(email: String): Member =
        memberRepository.findByEmail(email) ?: throw MemberNotFoundException()

}