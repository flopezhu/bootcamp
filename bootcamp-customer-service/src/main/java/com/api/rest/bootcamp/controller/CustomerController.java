package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.document.error.CustomerNotFoundException;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private ProductService productService;

    @GetMapping("/test/{id}")
    public Mono<ResponseEntity<CustomerTypeDto>> getCustomerTypeById(@PathVariable(name = "id") String id) {
        return customerTypeService.getCustomerTypeForId(id).map(customerTypeDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(customerTypeDto));
    }

    @GetMapping("/testP/{id}")
    public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable(name = "id") String id) {
        return productService.getProductForId(id).map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<CustomerDto>> saveCustomer(@Valid @RequestBody Mono<CustomerDto> customerDtoMono) {
        return customerService.save(customerDtoMono).map(customerDto -> ResponseEntity.created(URI.create("/api/customers/".concat(customerDto.getId())))
                .contentType(MediaType.APPLICATION_JSON).body(customerDto));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<CustomerDto>> updateCustomer(@RequestBody Mono<CustomerDto> customerDto,
                                                            @PathVariable String id) {

        return customerService.updateCustomer(customerDto, id).map(customers -> ResponseEntity.created(URI.create("/api/customers/".concat(customers.getId())))
                .contentType(MediaType.APPLICATION_JSON).body(customers)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerDto>> findCustomerById(@PathVariable(name = "id") String id) {
        return customerService.findById(id).map(customer -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(customer));
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<CustomerDto>>> findAllCustomers() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(customerService.findAll()));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteCustomer(@PathVariable(name = "id") String id) {
        return customerService.deleteById(id).map(customerDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(customerDto));
    }
}
