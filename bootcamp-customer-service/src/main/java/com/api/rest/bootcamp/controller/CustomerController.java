package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    /**
     * LOG for CustomerController.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CustomerController.class);
    /**
     * customer service.
     */
    @Autowired
    private CustomerService customerService;
    /**
     * customer type service of webclient.
     */
    @Autowired
    private CustomerTypeService customerTypeService;
    /**
     * product service for webclient.
     */
    @Autowired
    private ProductService productService;

    /**
     * @param id
     * @return test for webclient, get customer type for id.
     */
    @GetMapping("/test/{id}")
    public Mono<ResponseEntity<CustomerTypeDto>> getCustomerTypeById(
            @PathVariable(name = "id") final String id) {
        return customerTypeService.getCustomerTypeForId(id)
                .map(customerTypeDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customerTypeDto));
    }

    /**
     * @param id
     * @return test for product webclient, get product by id.
     */
    @GetMapping("/testP/{id}")
    public Mono<ResponseEntity<ProductDto>> getProductById(
            @PathVariable(name = "id") final String id) {
        return productService.getProductForId(id)
                .map(productDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productDto));
    }

    /**
     * @param customerDtoMono
     * @return save customer.
     */
    @PostMapping("/register")
    public Mono<ResponseEntity<CustomerDto>> saveCustomer(
            @Valid @RequestBody final Mono<CustomerDto> customerDtoMono) {
        return customerService.save(customerDtoMono)
                .map(customerDto -> ResponseEntity
                        .created(URI.create("/api/customers/"
                                .concat(customerDto.getId())))
                .contentType(MediaType.APPLICATION_JSON).body(customerDto));
    }

    /**
     * @param customerDto
     * @param id
     * @return update customer.
     */
    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<CustomerDto>> updateCustomer(
            @RequestBody final Mono<CustomerDto> customerDto,
            @PathVariable final String id) {

        return customerService.updateCustomer(customerDto, id)
                .map(customers -> ResponseEntity
                        .created(URI.create("/api/customers/"
                                .concat(customers.getId())))
                .contentType(MediaType.APPLICATION_JSON).body(customers))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /**
     * @param id
     * @return find customer by id.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerDto>> findCustomerById(
            @PathVariable(name = "id") final String id) {
        return customerService.findById(id)
                .map(customer -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customer));
    }

    /**
     * @return find all customers.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<CustomerDto>>> findAllCustomers() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerService.findAll()));
    }

    /**
     * @param id
     * @return delete customer by id.
     */
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteCustomerById(
            @PathVariable(name = "id") final String id) {
        return customerService.deleteById(id)
                .map(customerDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customerDto));
    }
}
