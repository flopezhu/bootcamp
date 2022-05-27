package com.api.rest.bootcamp.document.error;

public class CustomerNotFoundException extends  RuntimeException {
    /**
     * customer id.
     */
    private final String customerId;
    /**
     * message.
     */
    private static final String MESSAGE = "Customer not found";

    /**
     * @param id
     */
    public CustomerNotFoundException(final String id) {
        super(MESSAGE);
        this.customerId = id;
    }

    /**
     * @return customer id.
     */
    public String getCustomerId() {
        return customerId;
    }
}
