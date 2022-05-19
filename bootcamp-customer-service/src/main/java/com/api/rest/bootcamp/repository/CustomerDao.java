package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends ReactiveMongoRepository<Customer, String> {
}
