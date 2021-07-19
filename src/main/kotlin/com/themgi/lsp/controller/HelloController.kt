package com.themgi.lsp.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController(
    @Value("\${welcome.message}")
    private var welcomeMessage: String
) {

    @GetMapping
    fun helloWorld(): String {
        return this.welcomeMessage
    }
}