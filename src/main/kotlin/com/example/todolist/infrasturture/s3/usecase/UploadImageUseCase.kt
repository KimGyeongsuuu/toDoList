package com.example.todolist.infrasturture.s3.usecase

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.todolist.domain.image.usecase.UploadImageUseCase
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.io.InputStream
import java.util.*

@UseCaseWithTransaction
class UploadImageUseCase(
    private val amazonS3: AmazonS3
) : UploadImageUseCase {

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String? = null

    override fun execute(multipartFile: MultipartFile): String {
        val fileNameList = String()

        multipartFile?.let { file ->
            val fileName: String = createFileName(file.originalFilename.toString())
            val objectMetadata = ObjectMetadata()
            objectMetadata.contentLength = file.size
            objectMetadata.contentType = file.contentType
            try {
                val inputStream: InputStream = file.inputStream
                amazonS3.putObject(
                    PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
                )
            } catch (e: IOException) {
                throw IllegalStateException("파일 업로드에 실패했습니다.")
            }
            fileNameList.plus(fileName)
        }
        return fileNameList
    }

    private fun createFileName(fileName: String) =
        UUID.randomUUID().toString() + fileName

}
