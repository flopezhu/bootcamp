package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.CustomerType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerTypeDao extends MongoRepository<CustomerType, String> {
}
