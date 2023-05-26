package com.example.todolist.domain.post.usecase

import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.post.common.util.PostConverter
import com.example.todolist.domain.post.entity.repository.PostRepository
import com.example.todolist.domain.post.presentation.data.request.CreatePostRequest
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.stereotype.Service

@Service
@UseCaseWithTransaction
class CreatePostUsecase(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter,
    private val memberUtil: MemberUtil
) {

    fun execute(createPostRequest: CreatePostRequest) {
        postRepository.save(postConverter.toEntity(createPostRequest, memberUtil.currentMember()))
    }

}