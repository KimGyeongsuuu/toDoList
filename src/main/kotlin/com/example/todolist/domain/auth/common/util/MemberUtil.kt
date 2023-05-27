package com.example.todolist.domain.auth.common.util

import com.example.todolist.domain.member.entity.Member

interface MemberUtil {
    fun currentMember(): Member
}