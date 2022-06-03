package com.api.rest.bootcamp.api.client.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTypeResponse {
    /**
     * customer type dto id.
     */
    private String id;
    /**
     * customer type unique.
     */
    private String customerType;
}
