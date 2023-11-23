package com.example.springbootdemo.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String code;
    private String error;
    private String message;
    private String path;    
}
