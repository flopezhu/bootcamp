package com.api.rest.springdata.bootcamp.repository;

import com.api.rest.springdata.bootcamp.document.CustomerType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeDao extends MongoRepository<CustomerType, String> {
}
