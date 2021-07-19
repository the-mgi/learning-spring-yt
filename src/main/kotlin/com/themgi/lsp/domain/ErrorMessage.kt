package com.themgi.lsp.domain

import org.springframework.http.HttpStatus

class ErrorMessage(
    var status: HttpStatus? = null,
    var message: String? = null
)