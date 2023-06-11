package com.example.todolist.global.health

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<Map<String, String>> =
        ResponseEntity.ok(mapOf("message" to "ToDoList server running"))

}