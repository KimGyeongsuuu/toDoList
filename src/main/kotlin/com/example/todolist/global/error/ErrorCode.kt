package com.example.todolist.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    // TOKEN
    EXPIRATION_TOKEN("토큰이 만료되었습니다.", 403),
    INVALID_TOKEN("토큰이 유효하지 않습니다.", 403),

    // AUTH
    DUPLICATE_EMAIL("이미 존재하는 이메일입니다.", 409),
    MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다.", 400),

    // MEMBER
    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.", 404);
}