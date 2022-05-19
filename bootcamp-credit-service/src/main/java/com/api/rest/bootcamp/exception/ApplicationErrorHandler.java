package com.api.rest.bootcamp.exception;

import com.api.rest.bootcamp.document.error.CreditNotFoundException;
import com.api.rest.bootcamp.document.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        var errorResponse = this.buildErrorResponse(100, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    @ExceptionHandler(CreditNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CreditNotFoundException e) {
        var errorResponse = this.buildErrorResponse(101, String.format("Credit with id: '%s' not found", e.getCreditId()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    public ErrorResponse buildErrorResponse(int code, String message) {
        return new ErrorResponse(code, message);
    }
}
