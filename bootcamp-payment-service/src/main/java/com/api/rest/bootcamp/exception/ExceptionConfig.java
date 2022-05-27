package com.api.rest.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    /**
     * @param e
     * @return not found exception.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(final Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    /**
     * @param e
     * @return bad request exception.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(final Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
