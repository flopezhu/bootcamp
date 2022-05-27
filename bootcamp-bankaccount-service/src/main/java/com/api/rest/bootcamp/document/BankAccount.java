package com.api.rest.bootcamp.document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bankAccount")
public class BankAccount {
    /**
     * bank account id.
     */
    @Id
    private String id;
    /**
     * customer id.
     */
    private String customerId;
    /**
     * product id.
     */
    private String productId;
    /**
     * account number.
     */
    private int accountNumber;
    /**
     * account number cci.
     */
    private int accountNumberCCI;
    /**
     * currency.
     */
    private String currency;
    /**
     * amount available.
     */
    private String amountAvailable;
    /**
     * countable balance.
     */
    private String countableBalance;
    /**
     * creation date.
     */
    private Date creationDate;
}
