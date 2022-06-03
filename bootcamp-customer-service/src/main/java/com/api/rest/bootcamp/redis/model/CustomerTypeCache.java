package com.api.rest.bootcamp.redis.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("CustomerType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerTypeCache implements Serializable {
    /**
     * customer type dto id.
     */
    private String id;
    /**
     * customer type unique.
     */
    private String customerType;
}
