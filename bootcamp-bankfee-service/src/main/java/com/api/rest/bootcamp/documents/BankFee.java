package com.api.rest.bootcamp.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "bankFee")
public class BankFee {
    /**
     * bank fee id.
     */
    @Id
    private String id;
    /**
     * description for bank fee.
     */
    private String description;
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
    /**
     * status: 0 -> inactive | 1 -> active
     */
    private String status;


}
