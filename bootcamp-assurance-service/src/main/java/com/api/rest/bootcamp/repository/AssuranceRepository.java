package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.documents.Assurance;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends ReactiveMongoRepository<Assurance, String> {
}
