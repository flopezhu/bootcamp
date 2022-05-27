package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.exception.NotFoundException;
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
import reactor.core.scheduler.Schedulers;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CustomerServiceImpl implements CustomerService {
    /**
     * LOG for CustomerServiceImpl.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CustomerServiceImpl.class);
    /**
     * customer DAO.
     */
    @Autowired
    private CustomerDao customerDAO;
    /**
     * customer type service, webclient.
     */
    @Autowired
    private CustomerTypeService customerTypeService;

    /**
     * @return all customers.
     */
    @Override
    public Flux<CustomerDto> findAll() {
        return customerDAO.findAll().map(AppUtils::entityToDto);
    }

    /**
     * @param id
     * @return customer by id.
     */
    @Override
    public Mono<CustomerDto> findById(final String id) {
        return customerDAO.findById(id).map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new CustomerNotFoundException(id)));
    }

    /**
     * @param customer
     * @return save customer.
     */
    @Override
    public Mono<CustomerDto> save(final Mono<CustomerDto> customer) {
        Mono<String> customerId = customer.map(CustomerDto::getCustomerTypeId);
        return customer.filterWhen(customerDto -> {
           return Mono.sequenceEqual(customerTypeId(
                   customerDto.getCustomerTypeId()), customerId)
                    .switchIfEmpty(Mono.error(
                            new NotFoundException("Customer type not found")));
                })
                .map(AppUtils::dtoToEntities)
                .flatMap(customerDAO::insert)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new RuntimeException("save error")));
    }

    /**
     * @param customerDtoMono
     * @param id
     * @return update customer.
     */
    @Override
    public Mono<CustomerDto> updateCustomer(
            final Mono<CustomerDto> customerDtoMono, final String id) {
        return customerDAO.findById(id)
                .flatMap(customer -> customerDtoMono
                        .map(AppUtils::dtoToEntities))
                .doOnNext(next -> next.setId(id))
                .flatMap(customerDAO::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new CustomerNotFoundException(id)));
    }

    /**
     * @param id
     * @return delete customer by id.
     */
    @Override
    public Mono<String> deleteById(final String id) {
        return customerDAO.findById(id).flatMap(customer ->
                        this.customerDAO.deleteById(customer.getId())
                                .thenReturn("Customer has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new CustomerNotFoundException(id)));
    }

    /**
     * @param id
     * @return customer type id.
     */
    private Mono<String> customerTypeId(final String id) {
        return customerTypeService.getCustomerTypeForId(id)
                .map(CustomerTypeDto::getId);
    }

    private void validCustomerType(final Mono<CustomerDto> customerDtoMono,
                                   final Mono<String> id) {
        Mono<Object> customerMono = customerDtoMono
                .map(CustomerDto::getCustomerTypeId);
        Mono<CustomerTypeDto> customerTypeDtoMono = customerTypeService
                .getCustomerTypeForId(String.valueOf(customerMono));

        customerTypeDtoMono.zipWith(customerDtoMono)
                .filter(objects -> objects.getT2().getCustomerTypeId()
                        .equals(objects.getT1().getId()))
                .switchIfEmpty(Mono.error(new CustomerNotFoundException("id")));
    }

    private void getIdCustomerType(final Mono<CustomerDto> customerMono) {
        Mono<CustomerTypeDto> customerTypeDtoMono = customerTypeService
                .getCustomerTypeForId("62880f7ad06f1026aa65241fd");
        customerTypeDtoMono.zipWith(customerMono)
                .filter(objects -> objects.getT2().getCustomerTypeId()
                        .equals(objects.getT1().getId()))
                .switchIfEmpty(Mono.error(new RuntimeException("null")));
    }
}
