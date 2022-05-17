package com.api.rest.springdata.bootcamp.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String id;

    @NotBlank(message = "code is mandatory")
    private String code;

    @NotBlank(message = "signedDate is mandatory")
    private Date signedDate;

    @NotBlank(message = "ProductType is mandatory")
    private String productType;

    @NotBlank(message = "productName is mandatory")
    private String productName;

    @NotBlank(message = "status is mandatory")
    private String status;
}
