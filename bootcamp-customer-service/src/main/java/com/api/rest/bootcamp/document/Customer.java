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
    /**
     * customer id.
     */
    @Id
    private String id;
    /**
     * customer code.
     */
    private String code;
    /**
     * customer name.
     */
    private String name;
    /**
     * customer's lastname.
     */
    private String lastName;
    /**
     * customer sex.
     */
    private String sex;
    /**
     * customer date birth.
     */
    private Date dateBirth;
    /**
     * customer document type.
     */
    private String documentType;
    /**
     * customer document number.
     */
    private String documentNumber;
    /**
     * customer address.
     */
    private String address;
    /**
     * customer phone.
     */
    private String phone;
    /**
     * customer email.
     */
    private String email;
    /**
     * customer type id.
     */
    private String customerTypeId;
    /**
     * customer product id.
     */
    private String productId;
    /**
     * customer bank account id.
     */
    private String bankAccountId;
    /**
     * customer creation date.
     */
    private Date createdDate = new Date();
}
