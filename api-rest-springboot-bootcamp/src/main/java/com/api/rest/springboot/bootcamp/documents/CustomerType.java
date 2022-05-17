package com.api.rest.springboot.bootcamp.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
