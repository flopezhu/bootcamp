package com.api.rest.bootcamp.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
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
    private String customerId;
    private String ProductId;
    private Date createdDate;
}
