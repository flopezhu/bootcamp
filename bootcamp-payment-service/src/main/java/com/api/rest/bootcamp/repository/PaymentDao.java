package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends ReactiveMongoRepository<Payment, String> {
}
