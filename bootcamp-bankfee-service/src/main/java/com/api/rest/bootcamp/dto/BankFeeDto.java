package com.api.rest.bootcamp.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankFeeDto {
    /**
     * bank fee id.
     */
    private String id;
    /**
     * description for bank fee.
     */
    private String description;
    /**
     * minimum amount.
     */
    @NotBlank(message = "minimumAmount is mandatory")
    private BigDecimal minimumAmount;
    /**
     * maximum amount.
     */
    @NotBlank(message = "maximumAmount is mandatory")
    private BigDecimal maximumAmount;
    /**
     * price
     */
    @NotBlank(message = "price is mandatory")
    private BigDecimal price;
    /**
     * status: 0 -> inactive | 1 -> active
     */
    @NotBlank(message = "status is mandatory")
    private String status;
}
