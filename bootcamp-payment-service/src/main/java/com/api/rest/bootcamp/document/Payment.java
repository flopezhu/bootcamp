package com.api.rest.bootcamp.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment")
public class Payment {
    /**
     * payment id.
     */
    @Id
    private String id;
    /**
     * payment type consumption.
     */
    private String typeConsumption;
    /**
     * payment amount.
     */
    private String amount;
    /**
     * payment currency.
     */
    private String currency;
    /**
     * payment bank account.
     */
    private String bankAccount;
    /**
     * customer id.
     */
    private String customerId;
    /**
     * payment date.
     */
    private Date paymentDate;
}
