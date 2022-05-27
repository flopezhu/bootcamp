package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CustomerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    /**
     * @return get all customers.
     */
    Flux<CustomerDto> findAll();

    /**
     * @param id
     * @return get customer by id.
     */
    Mono<CustomerDto> findById(String id);

    /**
     * @param customer
     * @return save customer.
     */
    Mono<CustomerDto> save(Mono<CustomerDto> customer);

    /**
     * @param customerDtoMono
     * @param id
     * @return update customer for id.
     */
    Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono,
                                     String id);

    /**
     * @param id
     * @return delete customer by id.
     */
    Mono<String> deleteById(String id);
}
