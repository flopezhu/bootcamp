package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.service.CustomerTypeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    private static final String CUSTOMER_TYPE_INFO_SERVICE = "customerTypeInfoService";
    @Autowired
    private WebClient webClient;

    @Override
    //@CircuitBreaker(name = CUSTOMER_TYPE_INFO_SERVICE, fallbackMethod = "customerTypeInfoFallback")
    public Mono<CustomerTypeDto> getCustomerTypeForId(String id) {
        return webClient.get()
                .uri("/api/customerType/" + id)
                .retrieve()
                .bodyToMono(CustomerTypeDto.class);
    }

    public ResponseEntity<String> customerTypeInfoFallback(Exception e) {
        return new ResponseEntity<String>("GET: Customer type info endpoint is not available right now.", HttpStatus.OK);
    }
}
