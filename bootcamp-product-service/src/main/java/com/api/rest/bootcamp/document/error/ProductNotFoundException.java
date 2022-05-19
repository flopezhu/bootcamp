package com.api.rest.bootcamp.document.error;

public class ProductNotFoundException extends RuntimeException {
    private final String productId;
    private static final String MESSAGE = "Product not found";

    public ProductNotFoundException(String id) {
        super(MESSAGE);
        this.productId = id;
    }

    public String getProductId() {
        return productId;
    }
}
