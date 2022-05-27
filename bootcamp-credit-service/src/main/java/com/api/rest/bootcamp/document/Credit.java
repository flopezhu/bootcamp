package com.api.rest.bootcamp.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "credit")
public class Credit {
    /**
     * credit id.
     */
    @Id
    private String id;
    /**
     * credit amount.
     */
    private String amount;
    /**
     * credit limit.
     */
    private String creditLimit;
    /**
     * customer id.
     */
    private String customerId;
    /**
     * product id.
     */
    private String productId;
}
