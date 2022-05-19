package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CreditDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<CreditDto> getAllCredits();

    Mono<CreditDto> getCreditForId(String id);

    Mono<CreditDto> saveCredit(Mono<CreditDto> creditDtoMono);

    Mono<CreditDto> updateCreditForId(Mono<CreditDto> creditDtoMono, String id);

    Mono<String> deleteCreditForId(String id);
}
