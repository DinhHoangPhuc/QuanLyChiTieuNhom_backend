package com.quanlychiteunhom.backend.ExceptionHandler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quanlychiteunhom.backend.ResourceNotFoundException;

@RestControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundHandler(ResourceNotFoundException e) {
        return Map.of("error", e.getMessage());
    }
}
