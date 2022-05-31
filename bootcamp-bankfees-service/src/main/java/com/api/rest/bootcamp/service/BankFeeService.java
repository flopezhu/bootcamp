package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.documents.BankFee;
import com.api.rest.bootcamp.dto.BankFeeDto;
import com.api.rest.bootcamp.dto.BankFeeResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankFeeService {
    /**
     * @param bankFeeDtoMono
     * @return bankFeeDto.
     */
    Mono<BankFeeDto> createNewBankFee(Mono<BankFeeDto> bankFeeDtoMono);
    /**
     * @return all bank fees.
     */
    Flux<BankFeeResponse> getAllBankFeeResponse();

    /**
     * @return count objects.
     */
    Mono<Long> count();
}
