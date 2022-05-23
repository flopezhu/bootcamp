package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.Customer;
import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.repository.CustomerDao;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerDao customerDAO;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Override
    public Flux<CustomerDto> findAll() {
        return customerDAO.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<CustomerDto> findById(String id) {
        return customerDAO.findById(id).map(AppUtils::entityToDto).switchIfEmpty(Mono.error(() -> new CustomerNotFoundException(id)));
    }

    @Override
    public Mono<CustomerDto> save(Mono<CustomerDto> customer) {
        return customer.map(AppUtils::dtoToEntities)
                .flatMap(customerDAO::insert)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() -> new CustomerNotFoundException("error")));
    }

    @Override
    public Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono, String id) {
        return customerDAO.findById(id)
                .flatMap(customer -> customerDtoMono.map(AppUtils::dtoToEntities))
                .doOnNext(next -> next.setId(id))
                .flatMap(customerDAO::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() -> new CustomerNotFoundException(id)));
    }

    @Override
    public Mono<String> deleteById(String id) {
        return customerDAO.findById(id).flatMap(customer -> this.customerDAO.deleteById(customer.getId())
                .thenReturn("Customer has deleted")).switchIfEmpty(Mono.error(() -> new CustomerNotFoundException(id)));
    }
}
