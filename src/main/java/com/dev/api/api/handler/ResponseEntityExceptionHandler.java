package com.dev.api.api.handler;

import com.dev.api.api.execeptions.DatabaseException;
import com.dev.api.api.execeptions.NotFoundException;
import com.dev.api.api.execeptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ResponseException> notFound(NotFoundException ex, WebRequest request) {
        ResponseException exception = new ResponseException(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(DatabaseException.class)
    private ResponseEntity<ResponseException> database(DatabaseException ex, WebRequest request) {
        ResponseException exception = new ResponseException(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
}
