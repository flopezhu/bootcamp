package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.AssuranceDto;
import com.api.rest.bootcamp.dto.AssuranceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssuranceService {
    /**
     * @param assuranceDtoMono
     * @return bankFeeDto.
     */
    Mono<AssuranceDto> createNewAssurance(Mono<AssuranceDto> assuranceDtoMono);
    /**
     * @return all bank fees.
     */
    Flux<AssuranceResponse> getAllAssuranceResponse();

    /**
     * @return count objects.
     */
    Mono<Long> count();

    Mono<String> deleteAssuranceForId(String id);

}
