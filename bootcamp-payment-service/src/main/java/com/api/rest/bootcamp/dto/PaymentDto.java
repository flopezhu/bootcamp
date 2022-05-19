package com.api.rest.bootcamp.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private String id;
    private String typeConsumption;
    private String amount;
    private String currency;
    private String bankAccount;
    private String customerId;
    private Date paymentDate;
}
