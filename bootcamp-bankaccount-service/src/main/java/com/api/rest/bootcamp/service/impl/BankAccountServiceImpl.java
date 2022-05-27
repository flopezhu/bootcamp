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
    /**
     * log for bankAccountServiceImpl.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(BankAccountServiceImpl.class);
    /**
     * bank account dao.
     */
    @Autowired
    private BankAccountDao bankAccountDao;

    /**
     * @return all accounts.
     */
    @Override
    public Flux<BankAccountDto> findAllBankAccount() {
        LOG.info("TEST");
        return bankAccountDao.findAll().map(AppUtils::entityToDto);
    }

    /**
     * @param id
     * @return find account by id.
     */
    @Override
    public Mono<BankAccountDto> findBankAccountById(final String id) {
        return bankAccountDao.findById(id).map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new BankAccountNotFoundException(id)));
    }

    /**
     * @param bankAccountDtoMono
     * @return save account.
     */
    @Override
    public Mono<BankAccountDto> saveBankAccount(
            final Mono<BankAccountDto> bankAccountDtoMono) {
        return bankAccountDtoMono.map(AppUtils::dtoToEntities)
                .flatMap(bankAccountDao::insert)
                .map(AppUtils::entityToDto);
    }

    /**
     * @param bankAccountDtoMono
     * @param id
     * @return update bank account.
     */
    @Override
    public Mono<BankAccountDto> updateBankAccount(
            final Mono<BankAccountDto> bankAccountDtoMono, final String id) {
        return bankAccountDao.findById(id)
                .flatMap(customer -> bankAccountDtoMono
                        .map(AppUtils::dtoToEntities))
                .doOnNext(next -> next.setId(id))
                .flatMap(bankAccountDao::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new BankAccountNotFoundException(id)));
    }

    /**
     * @param id
     * @return delete bank account id.
     */
    @Override
    public Mono<String> deleteBankAccountById(final String id) {
        return bankAccountDao.findById(id).flatMap(customer ->
                this.bankAccountDao.deleteById(customer.getId())
                .thenReturn("Customer has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new BankAccountNotFoundException(id)));
    }
}
