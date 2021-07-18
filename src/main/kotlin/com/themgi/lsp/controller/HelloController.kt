package com.themgi.lsp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun helloWorld(): String {
        return "Welcome to the SPRING WORLD hehe"
    }
}