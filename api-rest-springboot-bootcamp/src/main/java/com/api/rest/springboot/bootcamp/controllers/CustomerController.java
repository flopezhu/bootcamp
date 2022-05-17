package com.api.rest.springboot.bootcamp.controllers;

import com.api.rest.springboot.bootcamp.dto.CustomerDto;
import com.api.rest.springboot.bootcamp.exceptions.BadRequestException;
import com.api.rest.springboot.bootcamp.service.CustomerService;
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
