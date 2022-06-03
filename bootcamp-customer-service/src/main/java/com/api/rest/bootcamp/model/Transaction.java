package com.api.rest.bootcamp.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Transaction implements Serializable {
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
