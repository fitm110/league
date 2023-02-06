package com.dockerforjavadevelopers.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.Optional;

@ControllerAdvice
public class ControllerAdviceErrorHandlers {
    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<String> handleIOException(IOException ex, WebRequest webRequest) {
        return ResponseEntity.of(Optional.of("error " + ex.getMessage()));
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex, WebRequest webRequest) {
        return ResponseEntity.of(Optional.of("error " + ex + ".\n" + "errorMsg:" + ex.getMessage()));
    }
}
