package com.example.todolist.domain.post.common.util.impl

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.post.common.util.PostConverter
import com.example.todolist.domain.post.entity.Post
import com.example.todolist.domain.post.presentation.data.request.CreatePostRequest
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostConverterImpl(

) : PostConverter{
    override fun toEntity(createPostRequest: CreatePostRequest, member: Member): Post =
        Post(
            idx = UUID.randomUUID(),
            title = createPostRequest.title,
            content = createPostRequest.content,
            member = member
        )

}