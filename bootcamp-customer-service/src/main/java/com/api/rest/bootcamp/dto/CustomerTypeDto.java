package com.api.rest.bootcamp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerTypeDto {
    /**
     * customer type id.
     */
    private String id;
    /**
     * customer type code.
     */
    private String code;
    /**
     * customer type.
     */
    private String customerType;
    /**
     * customer type description.
     */
    private String description;
}
