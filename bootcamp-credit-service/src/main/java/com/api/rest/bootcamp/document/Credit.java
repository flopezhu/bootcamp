package com.api.rest.bootcamp.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "credit")
public class Credit {
    @Id
    private String id;

    @NotBlank(message = "amount is mandatory")
    private String amount;

    @NotBlank(message = "creditLimit is mandatory")
    private String creditLimit;

    @NotBlank(message = "customerId is mandatory")
    private String customerId;

    @NotBlank(message = "productId is mandatory")
    private String productId;
}
