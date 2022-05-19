package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.BankAccountNotFoundException;
import com.api.rest.bootcamp.dto.BankAccountDto;
import com.api.rest.bootcamp.repository.BankAccountDao;
import com.api.rest.bootcamp.service.BankAccountService;
import com.api.rest.bootcamp.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private static final Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public Flux<BankAccountDto> findAllBankAccount() {
        log.info("TEST");
        return bankAccountDao.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<BankAccountDto> findBankAccountById(String id) {
        return bankAccountDao.findById(id).map(AppUtils::entityToDto).switchIfEmpty(Mono.error(() -> new BankAccountNotFoundException(id)));
    }

    @Override
    public Mono<BankAccountDto> saveBankAccount(Mono<BankAccountDto> bankAccountDtoMono) {
        return bankAccountDtoMono.map(AppUtils::dtoToEntities)
                .flatMap(bankAccountDao::insert)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<BankAccountDto> updateBankAccount(Mono<BankAccountDto> bankAccountDtoMono, String id) {
        return bankAccountDao.findById(id)
                .flatMap(customer -> bankAccountDtoMono.map(AppUtils::dtoToEntities))
                .doOnNext(next -> next.setId(id))
                .flatMap(bankAccountDao::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() -> new BankAccountNotFoundException(id)));
    }

    @Override
    public Mono<String> deleteBankAccountById(String id) {
        return bankAccountDao.findById(id).flatMap(customer -> this.bankAccountDao.deleteById(customer.getId())
                .thenReturn("Customer has deleted")).switchIfEmpty(Mono.error(() -> new BankAccountNotFoundException(id)));
    }
}
