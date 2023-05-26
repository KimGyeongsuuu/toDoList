package com.example.todolist.domain.post.entity.repository

import com.example.todolist.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository : JpaRepository<Post, UUID>