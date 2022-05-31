package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.documents.BankFee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankFeeRepository extends ReactiveMongoRepository<BankFee, String> {
}
