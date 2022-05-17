package com.api.rest.springboot.bootcamp.service.impl;

import com.api.rest.springboot.bootcamp.documents.CustomerType;
import com.api.rest.springboot.bootcamp.documents.error.CustomerNotFoundException;
import com.api.rest.springboot.bootcamp.dto.CustomerDto;
import com.api.rest.springboot.bootcamp.exceptions.BadRequestException;
import com.api.rest.springboot.bootcamp.repository.CustomerDAO;
import com.api.rest.springboot.bootcamp.service.CustomerService;
import com.api.rest.springboot.bootcamp.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Flux<CustomerDto> findAll() {
        log.info("TEST");
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
                .map(AppUtils::entityToDto);
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
        //return customerDAO.deleteById(id).switchIfEmpty(Mono.error(() -> new CustomerNotFoundException(id)));
    }
}
