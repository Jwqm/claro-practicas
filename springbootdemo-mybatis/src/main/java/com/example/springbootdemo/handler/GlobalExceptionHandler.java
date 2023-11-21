package com.example.springbootdemo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.springbootdemo.model.ApiError;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler( {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleExceptions(Exception exception, WebRequest request) {
        log.error("Se ha producido un error en {}: {}", request.getDescription(false), exception.getMessage());
        return ApiError.builder()
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .error("Internal Server Error")
        .message(exception.getMessage())
        .path(request.getDescription(false))
        .build();
    }

}