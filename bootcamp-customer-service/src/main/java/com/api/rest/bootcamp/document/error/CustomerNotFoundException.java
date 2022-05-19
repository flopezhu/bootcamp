package com.api.rest.bootcamp.document.error;

public class CustomerNotFoundException extends  RuntimeException{
    private final String customerId;
    private static final String MESSAGE = "Customer not found";

    public CustomerNotFoundException(String id) {
        super(MESSAGE);
        this.customerId = id;
    }

    public String getCustomerId() {
        return customerId;
    }
}
