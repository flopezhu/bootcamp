package com.api.rest.bootcamp.document.error;

public class CreditNotFoundException extends RuntimeException {
    private final String creditId;
    private static final String MESSAGE = "Credit not found";

    public CreditNotFoundException(String id) {
        super(MESSAGE);
        this.creditId = id;
    }

    public String getCreditId() {
        return creditId;
    }
}
