package com.example.todolist.domain.post.common.util

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.post.entity.Post
import com.example.todolist.domain.post.presentation.data.request.CreatePostRequest

interface PostConverter {
    fun toEntity(createPostRequest: CreatePostRequest, member: Member) : Post
}