package com.example.todolist.domain.post.entity

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.*

@Entity
class Post (
    @Column(name = "post_idx")
    override val idx: UUID,
    @Column(name = "title")
    val title: String,
    @Column(name = "content")
    val content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val member: Member

) : BaseUUIDEntity(idx)