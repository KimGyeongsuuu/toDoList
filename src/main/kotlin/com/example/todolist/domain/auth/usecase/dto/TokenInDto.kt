package com.example.todolist.domain.auth.usecase.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class TokenInDto(
    val accessToken : String,
    val refreshToken : String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ss")
    val accessTokenExp: LocalDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ss")
    val refreshTokenExp: LocalDateTime
)
