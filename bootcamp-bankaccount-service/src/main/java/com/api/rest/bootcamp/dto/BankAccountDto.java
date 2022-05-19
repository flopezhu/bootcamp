package com.api.rest.bootcamp.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDto {
    private String id;
    private String customerId;
    private String productId;
    private String accountNumber;
    private String currency;
    private String amountAvailable;
    private String countableBalance;
    private Date creationDate;
}
