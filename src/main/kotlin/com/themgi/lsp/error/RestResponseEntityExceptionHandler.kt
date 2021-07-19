package com.themgi.lsp.error

import com.themgi.lsp.domain.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@ResponseStatus
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(DepartmentNotFoundException::class)
    fun departmentNotFoundException(
        departmentNotFoundException: DepartmentNotFoundException,
        webRequest: WebRequest
    ): ResponseEntity<ErrorMessage> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorMessage(
                HttpStatus.NOT_FOUND,
                departmentNotFoundException.message
            )
        )
    }
}