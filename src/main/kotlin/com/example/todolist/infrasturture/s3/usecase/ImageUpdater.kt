package com.example.todolist.infrasturture.s3.usecase

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.image.usecase.ImageUpdateUseCase
import com.example.todolist.domain.image.usecase.ImageUploadUseCase
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.infrasturture.s3.common.exception.NotExistImageException
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile

@UseCaseWithTransaction
class ImageUpdater(
    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String,
    private val imageUploadUseCase: ImageUploadUseCase,
    private val amazonS3: AmazonS3,
    private val memberUtil: MemberUtil
) : ImageUpdateUseCase {

    override fun execute(multipartFile: MultipartFile) {
        val currentMember = memberUtil.currentMember()
        if (currentMember.profileImageUrl.isEmpty()) {
            throw NotExistImageException()
        }
        deleteImage(currentMember.profileImageUrl)
        imageUploadUseCase.execute(multipartFile)
    }

    private fun deleteImage(fileName: String) {
        amazonS3.deleteObject(DeleteObjectRequest(bucket, fileName))
    }

}