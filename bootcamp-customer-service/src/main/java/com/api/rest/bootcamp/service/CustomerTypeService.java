package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.redis.model.CustomerTypeCache;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CustomerTypeService {
    /**
     * @return get customer type for id.
     */
    List<CustomerTypeCache> getAllCustomerType();
    String storageCustomerTypeList(List<CustomerTypeCache> customerTypeCache);
}
