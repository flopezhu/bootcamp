package com.api.rest.bootcamp.document.error;

public class CreditNotFoundException extends RuntimeException {
    /**
     * credit id.
     */
    private final String creditId;
    /**
     * message for default.
     */
    private static final String MESSAGE = "Credit not found";

    /**
     * @param id
     */
    public CreditNotFoundException(final String id) {
        super(MESSAGE);
        this.creditId = id;
    }

    /**
     * @return get credit id.
     */
    public String getCreditId() {
        return creditId;
    }
}
