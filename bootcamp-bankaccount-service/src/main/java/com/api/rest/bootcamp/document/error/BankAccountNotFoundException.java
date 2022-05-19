package com.api.rest.bootcamp.document.error;

public class BankAccountNotFoundException extends RuntimeException {
    private final String bankAccountId;
    private static final String MESSAGE = "Account not found";

    public BankAccountNotFoundException(String id) {
        super(MESSAGE);
        this.bankAccountId = id;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }
}
