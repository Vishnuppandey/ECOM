package com.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> categoryNotFound(CategoryNotFoundException productNotFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFound.getMessage());
    }
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> productnotfound(ProductNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
