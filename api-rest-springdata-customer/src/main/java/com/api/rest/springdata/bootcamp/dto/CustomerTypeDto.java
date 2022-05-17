package com.api.rest.springdata.bootcamp.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerTypeDto {
    private String id;
    private String code;
    private String customerType;
    private String description;
}
