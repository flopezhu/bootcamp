package com.api.rest.springdata.bootcamp.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customerType")
public class CustomerType {
    @Id
    private String id;

    @NotBlank(message = "code is mandatory")
    private String code;

    @NotBlank(message = "customerType is mandatory")
    private String customerType;

    private String description;

}
