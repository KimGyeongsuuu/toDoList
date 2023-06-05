package com.example.todolist.domain.member.entity

import com.example.todolist.global.entity.BaseUUIDEntity
import com.example.todolist.global.role.Role
import java.util.*
import javax.persistence.*

@Entity
class Member(
    @Column(name = "member_idx")
    override val idx: UUID,
    @Column(name = "email")
    val email: String,
    @Column(name = "password")
    val password: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "profile_image_url")
    var profileImageUrl: String,
    @Enumerated(EnumType.STRING)
    val role: Role
) : BaseUUIDEntity(idx) {

    fun updateProfileImageUrl(profileImageUrl: String) {
        this.profileImageUrl = profileImageUrl
    }

}