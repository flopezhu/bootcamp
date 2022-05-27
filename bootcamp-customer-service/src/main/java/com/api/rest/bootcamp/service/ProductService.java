package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface ProductService {
    /**
     * @param id
     * @return get product for id.
     */
    Mono<ProductDto> getProductForId(String id);
}
