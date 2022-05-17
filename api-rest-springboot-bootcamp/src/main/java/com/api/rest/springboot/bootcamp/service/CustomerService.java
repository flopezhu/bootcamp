package com.api.rest.springboot.bootcamp.service;

import com.api.rest.springboot.bootcamp.dto.CustomerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDto> findAll();

    Mono<CustomerDto> findById(String id);

    Mono<CustomerDto> save(Mono<CustomerDto> customer);

    Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, String id);

    Mono<String> deleteById(String id);
}
