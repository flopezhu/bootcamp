package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.BankFeeResponse;
import com.api.rest.bootcamp.service.BankFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/bankfee")
public class BankFeeController {
    /**
     * bank fee service.
     */
    @Autowired
    private BankFeeService bankFeeService;

    @GetMapping
    public Mono<ResponseEntity<Flux<BankFeeResponse>>> findAllCustomers() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bankFeeService.getAllBankFeeResponse()));
    }
}

