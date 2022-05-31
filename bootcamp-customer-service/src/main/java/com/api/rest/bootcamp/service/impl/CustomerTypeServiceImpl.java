package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.exception.NotFoundException;
import com.api.rest.bootcamp.service.CustomerTypeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Getter
public class CustomerTypeServiceImpl implements CustomerTypeService {
    /**
     * web client.
     */
    @Autowired
    private  WebClient webClient;

    //private ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

    /**
     * @param id
     * @return consume the customerType microservice and get
     * a customerType by id.
     */
    @Override
    public Mono<CustomerTypeDto> getCustomerTypeForId(final String id) {
        return webClient.get()
                .uri("/api/customerType/" + id)
                .retrieve()
                .bodyToMono(CustomerTypeDto.class)
                .switchIfEmpty(Mono
                        .error(new NotFoundException("Customer id: 's%'" +
                                " not found or service is not available"+ id)));
    }
}
