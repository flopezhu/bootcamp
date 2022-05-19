package com.api.rest.bootcamp.exception;

import com.api.rest.bootcamp.document.error.ErrorResponse;
import com.api.rest.bootcamp.document.error.PaymentNotFoundException;
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

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(PaymentNotFoundException e) {
        var errorResponse = this.buildErrorResponse(101, String.format("Product with id: '%s' not found", e.getPaymentId()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    public ErrorResponse buildErrorResponse(int code, String message) {
        return new ErrorResponse(code, message);
    }
}
