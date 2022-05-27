package com.api.rest.bootcamp.document.error;

public class ProductNotFoundException extends RuntimeException {
    /**
     * product id.
     */
    private final String productId;
    /**
     * message for default.
     */
    private static final String MESSAGE = "Product not found";

    /**
     * @param id
     */
    public ProductNotFoundException(final String id) {
        super(MESSAGE);
        this.productId = id;
    }

    /**
     * @return get product id.
     */
    public String getProductId() {
        return productId;
    }
}
