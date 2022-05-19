package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.BankAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {
    Flux<BankAccountDto> findAllBankAccount();

    Mono<BankAccountDto> findBankAccountById(String id);

    Mono<BankAccountDto> saveBankAccount(Mono<BankAccountDto> bankAccountDtoMono);

    Mono<BankAccountDto> updateBankAccount(Mono<BankAccountDto> bankAccountDtoMono, String id);

    Mono<String> deleteBankAccountById(String id);
}
