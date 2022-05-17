package com.api.rest.springboot.bootcamp.exceptions;

import com.api.rest.springboot.bootcamp.documents.error.CustomerNotFoundException;
import com.api.rest.springboot.bootcamp.documents.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        var errorResponse = this.buildErrorResponse(100, "unable to fetch");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
        var errorResponse = this.buildErrorResponse(101, String.format("Customer id %s is not found", e.getCustomerId()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    public ErrorResponse buildErrorResponse(int code, String message) {
        return new ErrorResponse(code, message);
    }
}
