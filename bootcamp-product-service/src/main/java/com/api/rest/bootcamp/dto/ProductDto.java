package com.api.rest.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    /**
     * product dto id.
     */
    private String id;
    /**
     * product dto code.
     */
    @NotBlank(message = "code is mandatory")
    private String code;
    /**
     * product dto type.
     */
    @NotBlank(message = "productType is mandatory")
    private String productType;
    /**
     * product dto name.
     */
    @NotBlank(message = "productName is mandatory")
    private String productName;
    /**
     * product dto description.
     */
    @NotBlank(message = "description is mandatory")
    private String description;
    /**
     * product dto creation date.
     */
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT-05:00")
    private Date creationDate = new Date();
}
