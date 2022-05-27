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
    /**
     * customerDto id.
     */
    private String id;
    /**
     * customer code.
     */
    private String code;
    /**
     * customer name.
     */
    @NotBlank(message = "name is mandatory")
    private String name;
    /**
     * customer lastname.
     */
    @NotBlank(message = "lasName is mandatory")
    private String lastName;
    /**
     * customer sex.
     */
    @NotBlank(message = "sex is mandatory")
    private String sex;
    /**
     * customer date birth.
     */
    private Date dateBirth;
    /**
     * customer document type.
     */
    @NotBlank(message = "documentType is mandatory")
    private String documentType;
    /**
     * customer document number.
     */
    @NotBlank(message = "documentNumber is mandatory")
    private String documentNumber;
    /**
     * customer address.
     */
    @NotBlank(message = "address is mandatory")
    private String address;
    /**
     * customer phone.
     */
    private String phone;
    /**
     * customer email.
     */
    @NotBlank(message = "email is mandatory")
    private String email;
    /**
     * customer type id.
     */
    @NotBlank(message = "customerTypeId is mandatory")
    private String customerTypeId;
    /**
     * customer product id.
     */
    @NotBlank(message = "ProductId is mandatory")
    private String productId;
    /**
     * customer bank account id.
     */
    @NotBlank(message = "bankAccountId is mandatory")
    private String bankAccountId;
    /**
     * customer creation date.
     */
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT-05:00")
    private Date createdDate = new Date();
}
