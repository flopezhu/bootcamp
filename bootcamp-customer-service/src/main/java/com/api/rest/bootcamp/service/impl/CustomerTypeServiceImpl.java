package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
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
    @Autowired
    private  WebClient webClient;

    private ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

    @Override
    public Mono<CustomerTypeDto> getCustomerTypeForId(String id) {
        return webClient.get()
                .uri("/api/customerType/" + id)
                .retrieve()
                .bodyToMono(CustomerTypeDto.class)
                .timeout(Duration.ofMillis(20_000))
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = this.reactiveCircuitBreakerFactory.create("customerTypeInfoService");
                    return rcb.run(it, throwable -> Mono.just(CustomerTypeDto.builder().build()));
                });
    }
}
