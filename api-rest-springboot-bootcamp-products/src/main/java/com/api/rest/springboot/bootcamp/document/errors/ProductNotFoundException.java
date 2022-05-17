package com.api.rest.springboot.bootcamp.document.errors;

public class ProductNotFoundException extends RuntimeException {
    private final String productId;
    private static final String MESSAGE = "Customer not found";

    public ProductNotFoundException(String id) {
        super(MESSAGE);
        this.productId = id;
    }

    public String getProductId() {
        return productId;
    }
}
