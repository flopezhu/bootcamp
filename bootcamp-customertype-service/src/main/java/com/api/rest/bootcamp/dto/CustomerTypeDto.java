package com.api.rest.bootcamp.dto;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTypeDto {
    /**
     * customer type dto id.
     */
    private String id;
    /**
     * code unique for customer type.
     */
    @NotBlank(message = "code is mandatory and unique")
    @Indexed(unique = true)
    private String code;
    /**
     * customer type unique.
     */
    @Indexed(unique = true)
    private String customerType;
    /**
     * customer type description.
     */
    private String description;
}
