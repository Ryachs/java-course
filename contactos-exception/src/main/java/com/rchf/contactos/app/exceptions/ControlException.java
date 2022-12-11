package com.rchf.contactos.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> ExceptionControl(Exception e) {
        // Lanza la respuesta con el codigo BAD_REQUEST
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
