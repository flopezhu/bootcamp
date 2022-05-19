package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends ReactiveMongoRepository<Product, String> {
}
