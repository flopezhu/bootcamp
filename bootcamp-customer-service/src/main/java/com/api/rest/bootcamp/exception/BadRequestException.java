package com.api.rest.bootcamp.exception;

public class BadRequestException extends RuntimeException {
    /**
     * constructor empty.
     */
    public BadRequestException() {
    }

    /**
     * @param message
     */
    public BadRequestException(final String message) {
        super(message);
    }
}
