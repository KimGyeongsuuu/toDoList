package com.example.todolist.domain.image.usecase

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.todolist.global.annotation.UseCaseWithTransaction
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.io.InputStream
import java.util.*

@UseCaseWithTransaction
class UploadImageUseCase(
    private val amazonS3: AmazonS3
) {

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String? = null

    fun execute(multipartFiles: List<MultipartFile>?): List<String> {
        val fileNameList = ArrayList<String>()

        multipartFiles.orEmpty().forEach { file ->
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
            fileNameList.add(fileName)
        }
        return fileNameList
    }

    private fun createFileName(fileName: String) =
        UUID.randomUUID().toString() + fileName

}
