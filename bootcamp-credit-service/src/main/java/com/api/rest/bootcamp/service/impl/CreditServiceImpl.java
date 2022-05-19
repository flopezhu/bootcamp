package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.CreditNotFoundException;
import com.api.rest.bootcamp.dto.CreditDto;
import com.api.rest.bootcamp.repository.CreditDao;
import com.api.rest.bootcamp.service.CreditService;
import com.api.rest.bootcamp.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

    private static final Logger log = LoggerFactory.getLogger(CreditServiceImpl.class);

    @Autowired
    private CreditDao creditDao;

    @Override
    public Flux<CreditDto> getAllCredits() {
        return creditDao.findAll().map(AppUtil::entityToDto);
    }

    @Override
    public Mono<CreditDto> getCreditForId(String id) {
        return creditDao.findById(id).map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() -> new CreditNotFoundException(id)));
    }

    @Override
    public Mono<CreditDto> saveCredit(Mono<CreditDto> creditDtoMono) {
        return creditDtoMono.map(AppUtil::dtoToEntities)
                .flatMap(this.creditDao::insert)
                .map(AppUtil::entityToDto);
    }

    @Override
    public Mono<CreditDto> updateCreditForId(Mono<CreditDto> creditDtoMono, String id) {
        return creditDao.findById(id)
                .flatMap(product -> creditDtoMono.map(AppUtil::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(creditDao::save)
                .map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() -> new CreditNotFoundException(id)));
    }

    @Override
    public Mono<String> deleteCreditForId(String id) {
        return creditDao.findById(id).flatMap(product -> this.creditDao.deleteById(product.getId())
                .thenReturn("The Product has deleted")).switchIfEmpty(Mono.error(() -> new CreditNotFoundException(id)));
    }
}
