package com.example.todolist.domain.member.common.exception

import com.example.todolist.global.error.ErrorCode
import com.example.todolist.global.error.exceptions.ToDoException

class MemberNotFoundException : ToDoException(ErrorCode.MEMBER_NOT_FOUND)