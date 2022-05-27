package com.api.rest.bootcamp.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {
    /**
     * product id.
     */
    private String id;
    /**
     * product code.
     */
    private String code;
    /**
     * product type.
     */
    private String productType;
    /**
     * product name.
     */
    private String productName;
    /**
     * product description.
     */
    private String description;
    /**
     * product date.
     */
    private Date date;
}
