package com.example.demo

import com.example.demo.rest.v1.RestError
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalExceptionHandler {

    val log = LoggerFactory.getLogger(javaClass);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleThrowable(ex: Exception, request: WebRequest?, response: HttpServletResponse?): RestError {
        log.error(ex.message, ex)
        return RestError(ex.localizedMessage, "We messed up big time.")
    }

}