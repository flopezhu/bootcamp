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
    /**
     * LOG for CreditServiceImpl.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CreditServiceImpl.class);
    /**
     * credit DTO.
     */
    @Autowired
    private CreditDao creditDao;

    /**
     * @return get all credits.
     */
    @Override
    public Flux<CreditDto> getAllCredits() {
        return creditDao.findAll().map(AppUtil::entityToDto);
    }

    /**
     * @param id
     * @return get credit for id.
     */
    @Override
    public Mono<CreditDto> getCreditForId(final String id) {
        return creditDao.findById(id).map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new CreditNotFoundException(id)));
    }

    /**
     * @param creditDtoMono
     * @return save credit.
     */
    @Override
    public Mono<CreditDto> saveCredit(final Mono<CreditDto> creditDtoMono) {
        return creditDtoMono.map(AppUtil::dtoToEntities)
                .flatMap(this.creditDao::insert)
                .map(AppUtil::entityToDto);
    }

    /**
     * @param creditDtoMono
     * @param id
     * @return update credit for id.
     */
    @Override
    public Mono<CreditDto> updateCreditForId(
            final Mono<CreditDto> creditDtoMono, final String id) {
        return creditDao.findById(id)
                .flatMap(product -> creditDtoMono.map(AppUtil::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(creditDao::save)
                .map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() -> new CreditNotFoundException(id)));
    }

    /**
     * @param id
     * @return delete credit for id.
     */
    @Override
    public Mono<String> deleteCreditForId(final String id) {
        return creditDao.findById(id).flatMap(product ->
                this.creditDao.deleteById(product.getId())
                .thenReturn("The Product has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new CreditNotFoundException(id)));
    }
}
