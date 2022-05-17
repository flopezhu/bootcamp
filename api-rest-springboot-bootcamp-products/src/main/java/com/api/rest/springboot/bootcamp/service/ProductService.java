package com.api.rest.springboot.bootcamp.service;

import com.api.rest.springboot.bootcamp.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDto> getAllProducts();

    Mono<ProductDto> getProductForId(String id);

    Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono);

    Mono<ProductDto> updateProductForId(Mono<ProductDto> productDtoMono, String id);

    Mono<String> deleteProductForId(String id);
}
