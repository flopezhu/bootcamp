package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.BankAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {
    /**
     * @return all account.
     */
    Flux<BankAccountDto> findAllBankAccount();

    /**
     * @param id
     * @return account by id.
     */
    Mono<BankAccountDto> findBankAccountById(String id);

    /**
     * @param bankAccountDtoMono
     * @return save account and return a json.
     */
    Mono<BankAccountDto> saveBankAccount(
            Mono<BankAccountDto> bankAccountDtoMono);

    /**
     * @param bankAccountDtoMono
     * @param id
     * @return update bank account and return a json.
     */
    Mono<BankAccountDto> updateBankAccount(
            Mono<BankAccountDto> bankAccountDtoMono, String id);

    /**
     * @param id
     * @return a message deleted.
     */
    Mono<String> deleteBankAccountById(String id);
}
