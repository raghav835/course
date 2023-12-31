package com.cms.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        // Handle all exceptions and return an appropriate response entity
        return null;
    }

    public final ResponseEntity<ExceptionResponse> handleNotFoundException(AssociateInvalidException ex, WebRequest request) {
        // Handle the specific AssociateInvalidException and return an appropriate response entity
        return null;
    }
}
