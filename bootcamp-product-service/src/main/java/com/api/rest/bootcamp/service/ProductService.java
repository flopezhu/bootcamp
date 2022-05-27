package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    /**
     * @return get all products.
     */
    Flux<ProductDto> getAllProducts();

    /**
     * @param id
     * @return get product for id.
     */
    Mono<ProductDto> getProductForId(String id);

    /**
     * @param productDtoMono
     * @return save product.
     */
    Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono);

    /**
     * @param productDtoMono
     * @param id
     * @return update product for id.
     */
    Mono<ProductDto> updateProductForId(Mono<ProductDto> productDtoMono,
                                        String id);

    /**
     * @param id
     * @return delete product for id.
     */
    Mono<String> deleteProductForId(String id);
}
