package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.redis.model.CustomerTypeCache;
import com.api.rest.bootcamp.repository.CustomerTypeRepository;
import com.api.rest.bootcamp.service.CustomerTypeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Getter
@Slf4j
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerTypeCache> getAllCustomerType() {
        try {
            List<CustomerTypeCache> customerTypeCache =
                    new ArrayList<>();
            customerTypeRepository
                    .findAll()
                    .forEach(customerTypeCache::add);
            return customerTypeCache;
        } catch (Exception e) {
            log.error("Error while trying to get " +
                    "customer type from Redis cache. "+
                    e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String storageCustomerTypeList(final List<CustomerTypeCache> customerTypeCache) {
        try {
            customerTypeRepository.saveAll(customerTypeCache);
            return "Customer type list create successfully";
        } catch (Exception e) {
            return "Error saving customer type cache list. "+
                    e.getMessage();
        }
    }
}
