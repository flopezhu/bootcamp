package com.api.rest.springdata.bootcamp.repository;

import com.api.rest.springdata.bootcamp.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends MongoRepository<Customer, String> {
}
