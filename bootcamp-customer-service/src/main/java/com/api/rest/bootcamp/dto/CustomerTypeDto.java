package com.api.rest.bootcamp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerTypeDto {
    private String id;
    private String code;
    private String customerType;
    private String description;
}
