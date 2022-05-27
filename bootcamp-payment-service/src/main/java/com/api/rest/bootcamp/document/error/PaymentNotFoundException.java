package com.api.rest.bootcamp.document.error;

public class PaymentNotFoundException extends RuntimeException {
    /**
     * payment id.
     */
    private final String paymentId;
    /**
     * message for payment.
     */
    private static final String MESSAGE = "Payment not found";

    /**
     * @param id
     */
    public PaymentNotFoundException(final String id) {
        super(MESSAGE);
        this.paymentId = id;
    }

    /**
     * @return payment id.
     */
    public String getPaymentId() {
        return paymentId;
    }
}
