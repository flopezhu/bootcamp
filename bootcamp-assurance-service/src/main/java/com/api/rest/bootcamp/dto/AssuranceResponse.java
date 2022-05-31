package com.api.rest.bootcamp.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceResponse {
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
