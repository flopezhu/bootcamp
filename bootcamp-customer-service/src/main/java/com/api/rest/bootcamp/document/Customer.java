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
    private String name;
    private String lastName;
    private String sex;
    private Date dateBirth;
    private String documentType;
    private String documentNumber;
    private String address;
    private String phone;
    private String email;
    private String customerTypeId;
    private String ProductId;
    private String bankAccountId;
    private Date createdDate = new Date();
}
