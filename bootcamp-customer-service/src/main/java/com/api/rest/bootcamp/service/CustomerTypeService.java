package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import reactor.core.publisher.Mono;

public interface CustomerTypeService {
    Mono<CustomerTypeDto> getCustomerTypeForId(String id);
}
