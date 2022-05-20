package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDto> getProductForId(String id);
}
