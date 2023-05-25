package com.example.todolist.domain.auth.entity.repository

import com.example.todolist.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>