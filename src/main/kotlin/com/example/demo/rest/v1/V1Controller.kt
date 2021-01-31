package com.example.demo.rest.v1

import com.example.errors.ApiException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import io.swagger.annotations.Api
import org.slf4j.LoggerFactory
import org.springframework.beans.TypeMismatchException
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.WebRequest
import java.util.zip.DataFormatException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

data class RestError(val message: String, val details: String) { }

@RestController
@RequestMapping(value = ["/api/v1/"])
@Api(tags = ["v1 API"])
abstract class V1Controller {

    val log = LoggerFactory.getLogger(javaClass);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApiException::class)
    @ResponseBody
    fun handleApiException(ex: ApiException, request: WebRequest?, response: HttpServletResponse?): RestError {
        log.error(ex.message, ex);
        return RestError(ex.localizedMessage, "We messed up.")
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException::class)
    @ResponseBody
    fun handleConverterErrors(ex: InvalidFormatException): RestError {
        log.error(ex.message, ex)
        return RestError(ex.localizedMessage, "Bad client input.")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TypeMismatchException::class)
    @ResponseBody
    fun handleConverterErrors(ex: TypeMismatchException): RestError {
        log.error(ex.message, ex)
        return RestError(ex.localizedMessage, "Bad client input.")
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException::class)
    @ResponseBody
    fun missingParameterExceptionHandler(ex: MissingServletRequestParameterException, request: HttpServletRequest?): RestError {
        log.error(ex.message, ex)
        return RestError(ex.localizedMessage, "Bad client input.")
    }

}