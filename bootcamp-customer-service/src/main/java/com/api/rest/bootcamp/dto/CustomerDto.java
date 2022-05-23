package com.api.rest.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
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

    @NotBlank(message = "customerTypeId is mandatory")
    private String customerTypeId;

    @NotBlank(message = "ProductId is mandatory")
    private String ProductId;

    @NotBlank(message = "bankAccountId is mandatory")
    private String bankAccountId;

    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss", timezone="GMT-05:00")
    private Date createdDate = new Date();
}
