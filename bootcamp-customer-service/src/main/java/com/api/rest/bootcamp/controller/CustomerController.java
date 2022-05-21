package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private ProductService productService;

    private static final String PRODUCT_TYPE_INFO_SERVICE = "productInfoService";


   /* @PostMapping("/register")
    public Mono<ResponseEntity<Map<String, Object>>> registerCustomer(@RequestBody Mono<CustomerDto> customerMono) {
        Map<String, Object> response = new HashMap<>();
        return customerMono.flatMap(customer -> {
            return customerService.save(customer).map(customerReturn -> {
                response.put("customer", customerReturn);
                response.put("message", "Customer saved successful");
                response.put("timestamp", new Date());
                return ResponseEntity.created(URI.create("/api/customer".concat(customerReturn.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            });
        }).onErrorResume(error -> {
            return Mono.just(error).cast(WebExchangeBindException.class)
                    .flatMap(errors -> Mono.just(errors.getFieldErrors()))
                    .flatMapMany(Flux::fromIterable)
                    .map(fieldError -> "The camp:" + " " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        response.put("errors", list);
                        response.put("timestamp", new Date());
                        response.put("status", HttpStatus.BAD_REQUEST.value());
                        return Mono.just(ResponseEntity.badRequest().body(response));
                    });
        });
        *//*return customerService.save(customer).map(customers -> ResponseEntity.created(URI.create("/api/customers".concat(customers.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(customers));*//*
    }*/

    @GetMapping("/test/{id}")
    public  Mono<ResponseEntity<CustomerTypeDto>> getCustomerTypeById(@PathVariable(name = "id") String id) {
        return customerTypeService.getCustomerTypeForId(id).map(customerTypeDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(customerTypeDto));
    }

    @GetMapping("/testP/{id}")
    @CircuitBreaker(name = PRODUCT_TYPE_INFO_SERVICE, fallbackMethod = "productInfoFallback")
    public  Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable(name = "id") String id) {
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

    public ResponseEntity<String> productInfoFallback(Exception e) {
        return new ResponseEntity<String>("GET: Product info endpoint is not available right now.", HttpStatus.OK);
    }
}
