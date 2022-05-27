package com.api.rest.bootcamp.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    /**
     * product id.
     */
    @Id
    private String id;
    /**
     * product code.
     */
    private String code;
    /**
     * product type.
     */
    private String productType;
    /**
     * product name.
     */
    private String productName;
    /**
     * product description.
     */
    private String description;
    /**
     * product creation time.
     */
    private Date creationTime;
}
