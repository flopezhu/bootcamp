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
    private String id;

    @NotBlank(message = "customerId is mandatory")
    private String customerId;

    @NotBlank(message = "productId is mandatory")
    private String productId;

    @NotBlank(message = "accountNumber is mandatory")
    private String accountNumber;

    @NotBlank(message = "currency is mandatory")
    private String currency;

    @org.springframework.beans.factory.annotation.Value("${some.key:0.00}")
    private String amountAvailable;

    @Value("${some.key:0.00}")
    private String countableBalance;

    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss", timezone="GMT-05:00")
    private Date creationDate;
}
