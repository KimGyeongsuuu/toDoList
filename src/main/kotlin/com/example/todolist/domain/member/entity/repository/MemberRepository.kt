package com.example.todolist.domain.member.entity.repository

import com.example.todolist.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MemberRepository : JpaRepository<Member, UUID> {
    fun findByEmail(email: String): Member?
    fun existsByEmail(email: String): Boolean
}