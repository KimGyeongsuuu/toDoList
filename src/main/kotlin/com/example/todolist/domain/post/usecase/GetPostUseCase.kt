package com.example.todolist.domain.post.usecase

import com.example.todolist.domain.auth.common.util.MemberConverter
import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.post.common.util.PostConverter
import com.example.todolist.domain.post.entity.repository.PostRepository
import com.example.todolist.domain.post.presentation.data.response.PostResponse
import com.example.todolist.global.annotation.UseCaseWithReadOnlyTransaction


@UseCaseWithReadOnlyTransaction
class GetPostUseCase(
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil,
    private val memberConverter: MemberConverter,
    private val postConverter: PostConverter
) {
    fun execute() : List<PostResponse> =
        postRepository.findAll()
            .map { postConverter.toDto(it, memberConverter.toMemberResponse(memberUtil.currentMember())) }

}