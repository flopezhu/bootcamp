package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.dto.AssuranceDto;
import com.api.rest.bootcamp.dto.AssuranceResponse;
import com.api.rest.bootcamp.repository.AssuranceRepository;
import com.api.rest.bootcamp.service.AssuranceService;
import com.api.rest.bootcamp.util.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AssuranceImpl implements AssuranceService {
    /**
     * bank fee repository.
     */
    private final AssuranceRepository assuranceRepository;

    /**
     * @param assuranceDtoMono
     * @return create a new assurance.
     */
    @Override
    public Mono<AssuranceDto> createNewAssurance(
            final Mono<AssuranceDto> assuranceDtoMono) {
        return assuranceDtoMono
                .map(AppUtils::dtoToEntities)
                .flatMap(assuranceRepository::insert)
                .map(AppUtils::entityToDto);
    }

    /**
     * @return all assurance.
     */
    @Override
    public Flux<AssuranceResponse> getAllAssuranceResponse() {
        return assuranceRepository.findAll()
                .map(AppUtils::entitiesToResponseBankFee);
    }

    /**
     * @return count objects.
     */
    @Override
    public Mono<Long> count() {
        return assuranceRepository.count();
    }
}
