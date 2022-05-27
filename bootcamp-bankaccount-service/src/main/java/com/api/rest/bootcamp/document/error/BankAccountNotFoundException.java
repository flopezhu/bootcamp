package com.api.rest.bootcamp.document.error;

public class BankAccountNotFoundException extends RuntimeException {
    /**
     * bank account id.
     */
    private final String bankAccountId;
    /**
     * message.
     */
    private static final String MESSAGE = "Account not found";

    /**
     * @param id
     */
    public BankAccountNotFoundException(final String id) {
        super(MESSAGE);
        this.bankAccountId = id;
    }

    /**
     * @return bank account id.
     */
    public String getBankAccountId() {
        return bankAccountId;
    }
}
