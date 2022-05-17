package com.api.rest.springdata.bootcamp.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String id;
    private String code;
    private Date signedDate;
    private String productType;
    private String productName;
    private String status;
}
