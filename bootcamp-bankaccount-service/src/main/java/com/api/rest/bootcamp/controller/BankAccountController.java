package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.BankAccountDto;
import com.api.rest.bootcamp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/bankAccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public Mono<ResponseEntity<Flux<BankAccountDto>>> getAllProducts() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(bankAccountService.findAllBankAccount()));
        //return productService.getAllProducts().map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BankAccountDto>> getProductForId(@PathVariable(name = "id") String id) {
        return bankAccountService.findBankAccountById(id).map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<BankAccountDto>> registerProduct(@RequestBody Mono<BankAccountDto> productDtoMono) {
        return bankAccountService.saveBankAccount(productDtoMono).map(productDto -> ResponseEntity.created(URI.create("/api/products".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @PutMapping("update/{id}")
    public Mono<ResponseEntity<BankAccountDto>> updateProduct(@RequestBody Mono<BankAccountDto> productDtoMono, @PathVariable(name = "id") String id) {
        return bankAccountService.updateBankAccount(productDtoMono, id).map(productDto -> ResponseEntity.created(URI.create("/api/product".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable(name = "id") String id) {
        return bankAccountService.deleteBankAccountById(id).map(product -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(product));
    }
}
