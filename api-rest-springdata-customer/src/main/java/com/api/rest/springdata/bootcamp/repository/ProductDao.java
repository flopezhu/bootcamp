package com.api.rest.springdata.bootcamp.repository;

import com.api.rest.springdata.bootcamp.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {
}
