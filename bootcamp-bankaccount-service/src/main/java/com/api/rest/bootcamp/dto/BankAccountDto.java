package com.api.rest.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDto {
    /**
     * bank account id.
     */
    private String id;
    /**
     * customer id.
     */
    @NotBlank(message = "customerId is mandatory")
    private String customerId;
    /**
     * product id.
     */
    @NotBlank(message = "productId is mandatory")
    private String productId;
    /**
     * account number generic.
     */
    private int accountNumber;
    /**
     * account number cci.
     */
    private int accountNumberCCI;
    /**
     * currency.
     */
    @NotBlank(message = "currency is mandatory")
    private String currency;
    /**
     * amount available 0.00 for default.
     */
    @org.springframework.beans.factory.annotation.Value("${some.key:0.00}")
    private String amountAvailable;
    /**
     * countable balance, 0.00 for default.
     */
    @Value("${some.key:0.00}")
    private String countableBalance;
    /**
     * creation date.
     */
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT-05:00")
    private Date creationDate = new Date();
}
