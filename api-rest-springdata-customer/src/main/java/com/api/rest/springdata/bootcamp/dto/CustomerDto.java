package com.api.rest.springdata.bootcamp.dto;

import com.api.rest.springdata.bootcamp.document.CustomerType;
import com.api.rest.springdata.bootcamp.document.Product;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

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
    private List<CustomerType> customerTypeList;
    private List<Product> productList;
}
