package com.api.rest.springboot.bootcamp.service.impl;

import com.api.rest.springboot.bootcamp.document.errors.ProductNotFoundException;
import com.api.rest.springboot.bootcamp.dto.ProductDto;
import com.api.rest.springboot.bootcamp.respository.ProductDAO;
import com.api.rest.springboot.bootcamp.service.ProductService;
import com.api.rest.springboot.bootcamp.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductDAO productRepository;

    @Override
    public Flux<ProductDto> getAllProducts() {
        return productRepository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ProductDto> getProductForId(String id) {
        return productRepository.findById(id).map(AppUtils::entityToDto).switchIfEmpty(Mono.error(() -> new ProductNotFoundException(id)));
    }

    @Override
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntities)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ProductDto> updateProductForId(Mono<ProductDto> productDtoMono, String id) {
        return productRepository.findById(id)
                .flatMap(product -> productDtoMono.map(AppUtils::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() -> new ProductNotFoundException(id)));
    }

    @Override
    public Mono<String> deleteProductForId(String id) {
        return productRepository.findById(id).flatMap(product -> this.productRepository.deleteById(product.getId())
                .thenReturn("The Product has deleted")).switchIfEmpty(Mono.error(() -> new ProductNotFoundException(id)));
    }
}
