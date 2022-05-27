package com.api.rest.bootcamp.exception;

public class NotFoundException extends RuntimeException {
    /**
     * empty constructor.
     */
    public NotFoundException() {
    }

    /**
     * @param message
     */
    public NotFoundException(final String message) {
        super(message);
    }
}
