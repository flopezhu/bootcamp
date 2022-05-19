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
    @Id
    private String id;

    @NotBlank(message = "typeConsumption is mandatory")
    private String typeConsumption;

    @NotBlank(message = "amount is mandatory")
    private String amount;

    @NotBlank(message = "currency is mandatory")
    private String currency;

    @NotBlank(message = "bankAccount is mandatory")
    private String bankAccount;

    @NotBlank(message = "customerId is mandatory")
    private String customerId;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT-05:00")
    private Date paymentDate = new Date();
}
