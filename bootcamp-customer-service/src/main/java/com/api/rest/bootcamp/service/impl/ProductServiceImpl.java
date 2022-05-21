package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
    //private static final String PRODUCT_TYPE_INFO_SERVICE = "productInfoService";
    @Autowired
    private WebClient webClient;

    @Override
    //@CircuitBreaker(name = PRODUCT_TYPE_INFO_SERVICE, fallbackMethod = "productInfoFallback")
    public Mono<ProductDto> getProductForId(String id) {
        return webClient.get()
                .uri("/api/products/" + id)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }

    public ResponseEntity<String> productInfoFallback(Exception e) {
        return new ResponseEntity<String>("GET: Product info endpoint is not available right now.", HttpStatus.OK);
    }
}
