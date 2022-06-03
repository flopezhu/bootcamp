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
@Document(collection = "assurance")
public class Assurance {
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
    private String minimumAmount;
    /**
     * maximum amount.
     */
    private String maximumAmount;
    /**
     * price
     */
    private String price;
    /**
     * status: 0 -> inactive | 1 -> active
     */
    private String status;

    /**
     * @return active.
     */
    public boolean isActive() {
        return this.status.equals("1");
    }
}
