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
    /**
     * customer type id.
     */
    @Id
    private String id;
    /**
     * customer type code.
     */
    private String code;
    /**
     * customer type.
     */
    private String customerType;
    /**
     * customer type description.
     */
    private String description;
}
