package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CreditDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    /**
     * @return get all credits.
     */
    Flux<CreditDto> getAllCredits();

    /**
     * @param id
     * @return get credit for id.
     */
    Mono<CreditDto> getCreditForId(String id);

    /**
     * @param creditDtoMono
     * @return save credit.
     */
    Mono<CreditDto> saveCredit(Mono<CreditDto> creditDtoMono);

    /**
     * @param creditDtoMono
     * @param id
     * @return update credit for id.
     */
    Mono<CreditDto> updateCreditForId(Mono<CreditDto> creditDtoMono, String id);

    /**
     * @param id
     * @return delete credit for id.
     */
    Mono<String> deleteCreditForId(String id);
}
