package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.dto.BankFeeDto;
import com.api.rest.bootcamp.dto.BankFeeResponse;
import com.api.rest.bootcamp.repository.BankFeeRepository;
import com.api.rest.bootcamp.service.BankFeeService;
import com.api.rest.bootcamp.util.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BankFeeImpl implements BankFeeService {
    /**
     * bank fee repository.
     */
    private final BankFeeRepository bankFeeRepository;

    /**
     * @param bankFeeDtoMono
     * @return create a new bank fees.
     */
    @Override
    public Mono<BankFeeDto> createNewBankFee(
            final Mono<BankFeeDto> bankFeeDtoMono) {
        return bankFeeDtoMono
                .map(AppUtils::dtoToEntities)
                .flatMap(bankFeeRepository::insert)
                .map(AppUtils::entityToDto);
    }

    /**
     * @return all bank fees.
     */
    @Override
    public Flux<BankFeeResponse> getAllBankFeeResponse() {
        return bankFeeRepository.findAll()
                .map(AppUtils::entitiesToResponseBankFee);
    }

    /**
     * @return count objects.
     */
    @Override
    public Mono<Long> count() {
        return bankFeeRepository.count();
    }
}
