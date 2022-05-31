package com.api.rest.bootcamp.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankFeeResponse {
    /**
     * bank fee id.
     */
    private String id;
    /**
     * minimum amount.
     */
    private BigDecimal minimumAmount;
    /**
     * maximum amount.
     */
    private BigDecimal maximumAmount;
    /**
     * price
     */
    private BigDecimal price;
}
