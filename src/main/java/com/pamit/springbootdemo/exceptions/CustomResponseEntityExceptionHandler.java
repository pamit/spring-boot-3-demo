package com.pamit.springbootdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler//(RecordNotFoundException.class)
    public ResponseEntity<ApplicationExceptionResponse> handleException(RecordNotFoundException ex,
                                                                        WebRequest request) {
        ApplicationExceptionResponse exceptionResponse = new ApplicationExceptionResponse(
                request.getDescription(true),
                Arrays.asList(ex.getMessage()),
                LocalDateTime.now());

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationExceptionResponse> handleException(Exception ex, WebRequest request) {
        ApplicationExceptionResponse exceptionResponse = new ApplicationExceptionResponse(
                request.getDescription(true),
                Arrays.asList(ex.getMessage()),
                LocalDateTime.now());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
