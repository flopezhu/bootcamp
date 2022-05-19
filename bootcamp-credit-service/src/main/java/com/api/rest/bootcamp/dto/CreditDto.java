package com.api.rest.bootcamp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDto {
    private String id;
    private String amount;
    private String creditLimit;
    private String customerId;
    private String productId;
}
