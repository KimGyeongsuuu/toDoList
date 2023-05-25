package com.example.todolist.domain.auth.presentation

import com.example.todolist.domain.auth.common.util.AccountConverter
import com.example.todolist.domain.auth.presentation.data.request.SignInRequest
import com.example.todolist.domain.auth.presentation.data.request.SignUpRequest
import com.example.todolist.domain.auth.presentation.data.response.TokenResponse
import com.example.todolist.domain.auth.usecase.SignInUseCase
import com.example.todolist.domain.auth.usecase.SignUpUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/auth")
class AuthController(
    private val accountConverter: AccountConverter,
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase
) {

    @PostMapping("/signup")
    fun signup(@RequestBody @Valid signUpRequest: SignUpRequest) : ResponseEntity<Void> =
        accountConverter.toDto(signUpRequest)
            .let { signUpUseCase.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build()}

    @PostMapping("/signin")
    fun signin(@RequestBody @Valid signInRequest: SignInRequest) : ResponseEntity<TokenResponse> =
        accountConverter.toDto(signInRequest)
            .let { signInUseCase.execute(it) }
            .let { accountConverter.toDto(it) }
            .let { ResponseEntity.ok(it)}

}