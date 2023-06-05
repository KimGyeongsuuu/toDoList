package com.example.todolist.infrasturture.s3.usecase

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.todolist.domain.auth.common.util.MemberUtil
import com.example.todolist.domain.image.usecase.ImageUploadUseCase
import com.example.todolist.domain.member.entity.Member
import com.example.todolist.global.annotation.UseCaseWithTransaction
import com.example.todolist.infrasturture.common.exception.MisMatchExtensionException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.io.IOException
import java.util.*

@UseCaseWithTransaction
class ImageUploader(
    private val amazonS3: AmazonS3,
    private val memberUtil: MemberUtil
) : ImageUploadUseCase {

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String? = null

    override fun execute(multipartFile: MultipartFile): String {
        val currentMember: Member = memberUtil.currentMember()

        val fileName = createFileName(multipartFile.originalFilename)
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = multipartFile.size
        objectMetadata.contentType = multipartFile.contentType

        multipartFile.inputStream.use { inputStream ->
            try {
                amazonS3.putObject(
                    PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
                )
            } catch (e: IOException) {
                throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다.")
            }
        }

        currentMember.updateProfileImageUrl(fileName)
        val url = amazonS3.getUrl(bucket, fileName).toString()
        return url
    }

    private fun createFileName(fileName: String?): String {
        return UUID.randomUUID().toString() + getFileExtension(fileName)
    }

    private fun getFileExtension(fileName: String?): String? {
        val extensions = listOf(".jpg", ".JPG", ".jpeg", ".JPEG", ".png", ".PNG")
        val fileExtension = fileName?.substring(fileName.lastIndexOf("."))

        return try {
            if (!fileName?.contains(fileExtension ?: "")!! || !extensions.contains(fileExtension)) {
                throw MisMatchExtensionException()
            }
            fileExtension
        } catch (e: StringIndexOutOfBoundsException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일($fileName) 입니다.")
        }
    }

}