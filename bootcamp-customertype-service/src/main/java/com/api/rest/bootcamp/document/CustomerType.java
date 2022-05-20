package com.api.rest.bootcamp.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerType")
public class CustomerType {
    @Id
    private String id;

    @NotBlank(message = "code is mandatory")
    @Indexed(unique=true)
    private String code;

    @NotBlank(message = "customerType is mandatory")
    private String customerType;
    private String description;
}
