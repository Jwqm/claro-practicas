package com.example.springbootdemo.commons.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.claro.amx.sp.commonslib.exception.impl.BusinessException;
import com.claro.amx.sp.commonslib.exception.impl.TechnicalException;
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
        .code(exception instanceof TechnicalException technicalException ? technicalException.getCode() : "900000")
        .message(exception.getMessage())
        .path(request.getDescription(false))
        .build();
    }

    @ExceptionHandler( {BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiError handleExceptions(BusinessException exception, WebRequest request) {
        log.error("Se ha producido un error en {}: {}", request.getDescription(false), exception.getMessage());
        return ApiError.builder()
        .status(HttpStatus.OK)
        .code(exception.getCode())
        .message(exception.getMessage())
        .path(request.getDescription(false))
        .build();
    }

}