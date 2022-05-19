package com.api.rest.bootcamp.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "customer")
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
    private String customerId;
    private String ProductId;

    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss", timezone="GMT-05:00")
    private Date createdDate = new Date();
}
