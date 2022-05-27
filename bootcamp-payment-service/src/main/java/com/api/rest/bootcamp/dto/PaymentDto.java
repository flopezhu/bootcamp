package com.api.rest.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    /**
     * payment dto id.
     */
    private String id;
    /**
     * payment dto type consumption.
     */
    @NotBlank(message = "typeConsumption is mandatory")
    private String typeConsumption;
    /**
     * payment amount.
     */
    @NotBlank(message = "amount is mandatory")
    private String amount;
    /**
     * payment currency.
     */
    @NotBlank(message = "currency is mandatory")
    private String currency;
    /**
     * payment bankAccount.
     */
    @NotBlank(message = "bankAccount is mandatory")
    @Indexed(unique = true)
    private String bankAccount;
    /**
     * customer id.
     */
    @NotBlank(message = "customerId is mandatory")
    private String customerId;
    /**
     * payment date.
     */
    @NotBlank(message = "paymentDate is mandatory")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT-05:00")
    private Date paymentDate;
}
