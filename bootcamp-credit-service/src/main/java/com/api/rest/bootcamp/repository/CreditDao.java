package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDao extends ReactiveMongoRepository<Credit, String> {
}
