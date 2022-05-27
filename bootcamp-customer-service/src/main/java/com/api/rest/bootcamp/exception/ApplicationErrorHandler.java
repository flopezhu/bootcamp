package com.api.rest.bootcamp.exception;

import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.document.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler {
    /**
     * not found exception.
     */
    private static final int CODE_ERROR_NOT_FOUND_EXCEPTION = 101;
    /**
     * code for runtime exception.
     */
    private static final int CODE_ERROR_RUNTIME_EXCEPTION = 100;

    /**
     * @param e
     * @return code and message in runtime exception.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
            final RuntimeException e) {
        ErrorResponse errorResponse
                = this.buildErrorResponse(CODE_ERROR_RUNTIME_EXCEPTION,
                e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
    /**
     * @param e
     * @return customer id not found.
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(
            final CustomerNotFoundException e) {
        ErrorResponse errorResponse
                = this.buildErrorResponse(CODE_ERROR_NOT_FOUND_EXCEPTION,
                String.format("Customer id %s is not found",
                        e.getCustomerId()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
    /**
     * @param code
     * @param message
     * @return code and message for error.
     */
    public ErrorResponse buildErrorResponse(final int code,
                                            final String message) {
        return new ErrorResponse(code, message);
    }
}
