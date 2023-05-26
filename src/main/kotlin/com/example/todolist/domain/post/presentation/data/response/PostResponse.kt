package com.example.todolist.domain.post.presentation.data.response

import com.example.todolist.domain.member.presentation.data.response.MemberResponse

data class PostResponse(
    val title:String,
    val content:String,
    val member: MemberResponse
)
