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
    /**
     * bank account service.
     */
    @Autowired
    private BankAccountService bankAccountService;

    /**
     * @return all accounts.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<BankAccountDto>>> getAllAccounts() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bankAccountService.findAllBankAccount()));
    }

    /**
     * @param id
     * @return account for id.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<BankAccountDto>> getAccountForId(
            @PathVariable(name = "id") final String id) {
        return bankAccountService.findBankAccountById(id)
                .map(productDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productDto));
    }

    /**
     * @param productDtoMono
     * @return register bank account.
     */
    @PostMapping("/register")
    public Mono<ResponseEntity<BankAccountDto>> registerAccount(
            @RequestBody final Mono<BankAccountDto> productDtoMono) {
        return bankAccountService.saveBankAccount(productDtoMono)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/products"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param productDtoMono
     * @param id
     * @return update bank account for id.
     */
    @PutMapping("update/{id}")
    public Mono<ResponseEntity<BankAccountDto>> updateAccountForId(
            @RequestBody final Mono<BankAccountDto> productDtoMono,
            @PathVariable(name = "id") final String id) {
        return bankAccountService.updateBankAccount(productDtoMono, id)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/product"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param id
     * @return delete account for id.
     */
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteAccountForId(
            @PathVariable(name = "id") final String id) {
        return bankAccountService.deleteBankAccountById(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON).body(product));
    }
}
