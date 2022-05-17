package com.api.rest.springboot.bootcamp.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    private String code;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "lasName is mandatory")
    private String lastName;

    @NotBlank(message = "sex is mandatory")
    private String sex;
    private Date dateBirth;

    @NotBlank(message = "documentType is mandatory")
    private String documentType;

    @NotBlank(message = "documentNumber is mandatory")
    private String documentNumber;

    @NotBlank(message = "address is mandatory")
    private String address;
    private String phone;

    @NotBlank(message = "email is mandatory")
    private String email;
    private List<CustomerType> customerTypeList;
    private List<Product> productList;
}
