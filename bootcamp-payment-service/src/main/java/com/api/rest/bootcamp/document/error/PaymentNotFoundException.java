package com.api.rest.bootcamp.document.error;

public class PaymentNotFoundException extends RuntimeException {
    private final String paymentId;
    private static final String MESSAGE = "Payment not found";

    public PaymentNotFoundException(String id) {
        super(MESSAGE);
        this.paymentId = id;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
