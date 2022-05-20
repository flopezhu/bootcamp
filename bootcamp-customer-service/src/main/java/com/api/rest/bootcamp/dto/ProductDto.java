package com.api.rest.bootcamp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {
    private String id;
    private String code;
    private String productType;
    private String productName;
    private String description;
    private String Date;
}
