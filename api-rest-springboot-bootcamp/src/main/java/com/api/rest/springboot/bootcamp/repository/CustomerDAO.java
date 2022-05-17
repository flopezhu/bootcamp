package com.api.rest.springboot.bootcamp.repository;

import com.api.rest.springboot.bootcamp.documents.Customer;
import com.api.rest.springboot.bootcamp.dto.CustomerDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerDAO extends ReactiveMongoRepository<Customer, String> {
}
