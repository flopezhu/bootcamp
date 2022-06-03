package com.api.rest.bootcamp.dto;

import com.api.rest.bootcamp.documents.Assurance;
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
    private String minimumAmount;
    /**
     * maximum amount.
     */
    private String maximumAmount;
    /**
     * price
     */
    private String price;
}
