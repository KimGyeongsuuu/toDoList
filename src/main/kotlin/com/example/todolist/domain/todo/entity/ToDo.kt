package com.example.todolist.domain.todo.entity

import com.example.todolist.domain.member.entity.Member
import com.example.todolist.domain.todo.usecase.dto.UpdateToDoDto
import com.example.todolist.global.entity.BaseUUIDEntity
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
class ToDo(
    @Column(name = "post_idx")
    override val idx: UUID,
    @Column(name = "title")
    var title: String,
    @Column(name = "content")
    var content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,
    @Column(name = "date")
    val date: LocalDate
) : BaseUUIDEntity(idx) {

    fun updateToDo(updateToDoDto: UpdateToDoDto) {
        this.title = updateToDoDto.title
        this.content = updateToDoDto.content
    }

}