package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.exception.CustomValidationException;
import com.api.rest.bootcamp.exception.NotFoundException;
import com.api.rest.bootcamp.repository.CustomerDao;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.ProductService;
import com.api.rest.bootcamp.util.AppUtils;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
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
     * product service
     */
    @Autowired
    private ProductService productService;
    /**
     * validate
     */
    @Autowired
    private Validator validator;

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
        return customer
                /*.filterWhen(customerDto -> customerTypeService
                        .getAllCustomerType()
                        .doOnNext(foundCustomerType ->
                                LOG.debug("Customer type exists: " +
                                        customerDto.getCustomerTypeId()))
                        .hasElement()
                        .map(success -> success))
                .filterWhen(customerDto -> productService
                        .getProductForId(customerDto.getProductId())
                        .doOnNext(foundProduct ->
                                LOG.debug("Product exists: " +
                                        customerDto.getProductId()))
                        .hasElement()
                        .map(success -> success))
                .map(customerDto -> {
                    errors(customerDto);
                    return customerDto;
                })*/
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
                /*.filterWhen(customerDto -> customerTypeService
                        .getCustomerTypeForId(customerDto.getCustomerTypeId())
                        .doOnNext(foundCustomerType ->
                                LOG.debug("Customer type exists: " +
                                        customerDto.getCustomerTypeId()))
                        .hasElement()
                        .map(success -> success))
                .filterWhen(customerDto -> productService
                        .getProductForId(customerDto.getProductId())
                        .doOnNext(foundProduct ->
                                LOG.debug("Product exists: " +
                                        customerDto.getProductId()))
                        .hasElement()
                        .map(success -> success))
                .map(customer -> {
                    DataBinder binder = new DataBinder(customer);
                    binder.setValidator(validator);
                    binder.validate();
                    if (binder.getBindingResult().hasErrors()) {
                        LOG.error(binder.getBindingResult()
                                .getAllErrors().toString());
                        throw new CustomValidationException(binder
                                .getBindingResult().getAllErrors());
                    }
                    return customer;
                })*/
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
        return customerDAO.findById(id)
                .flatMap(customer -> this.customerDAO
                        .deleteById(customer.getId())
                        .thenReturn("Customer has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new CustomerNotFoundException(id)));
    }

    /**
     * @param id
     * @return customer type id.
     */
    /*private Mono<String> customerTypeId(final String id) {
        return customerTypeService.getCustomerTypeForId(id)
                .map(CustomerTypeDto::getId);
    }*/

    /**
     * @param customer
     * register all errors
     */
    private void errors(final CustomerDto customer) {
        DataBinder binder = new DataBinder(customer);
        binder.setValidator(validator);
        binder.validate();
        if (binder.getBindingResult().hasErrors()) {
            LOG.error(binder.getBindingResult()
                    .getAllErrors().toString());
            throw new CustomValidationException(binder
                    .getBindingResult().getAllErrors());
        }
    }

    /*private void validCustomerType(final Mono<CustomerDto> customerDtoMono,
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
    }*/
}
