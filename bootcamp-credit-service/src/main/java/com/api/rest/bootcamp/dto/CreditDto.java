package com.api.rest.bootcamp.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDto {
    /**
     * credit id.
     */
    private String id;
    /**
     * credit amount.
     */
    @NotBlank(message = "amount is mandatory")
    private String amount;
    /**
     * credit limit.
     */
    @NotBlank(message = "creditLimit is mandatory")
    private String creditLimit;
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
}
