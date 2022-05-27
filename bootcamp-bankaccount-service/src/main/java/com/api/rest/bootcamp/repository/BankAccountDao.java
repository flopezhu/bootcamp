package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDao extends
        ReactiveMongoRepository<BankAccount, String> {
}
