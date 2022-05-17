package com.api.rest.springboot.bootcamp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String id;
    private String code;
    private String productType;
    private String productName;
    private String description;

}
