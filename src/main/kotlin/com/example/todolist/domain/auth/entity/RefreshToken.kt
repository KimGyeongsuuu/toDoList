package com.example.todolist.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit
import javax.persistence.Column

@RedisHash(value = "refreshToken")
data class RefreshToken(
    @Id
    val refreshToken: String,
    @Column(name = "email")
    val email: String,
    @TimeToLive(unit = TimeUnit.SECONDS)
    val expiredAt: Int
)