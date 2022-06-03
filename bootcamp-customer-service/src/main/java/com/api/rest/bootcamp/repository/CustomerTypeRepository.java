package com.api.rest.bootcamp.repository;

import com.api.rest.bootcamp.redis.model.CustomerTypeCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends
        CrudRepository<CustomerTypeCache, String> {
}
