package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.AssuranceDto;
import com.api.rest.bootcamp.dto.AssuranceResponse;
import com.api.rest.bootcamp.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "api/assurance")
public class AssuranceController {
    /**
     * bank fee service.
     */
    @Autowired
    private AssuranceService assuranceService;

    /**
     * @return all assurance.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<AssuranceResponse>>> findAllAssurance() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(assuranceService.getAllAssuranceResponse()));
    }

    /**
     * @return create a new assurance.
     */
    @PostMapping("/create")
    public Mono<ResponseEntity<AssuranceDto>> createNewAssurance(
            @Valid @RequestBody Mono<AssuranceDto> assuranceDtoMono) {
        return assuranceService.createNewAssurance(assuranceDtoMono)
                .map(assuranceDto -> ResponseEntity
                .created(URI.create("/api/assurance/"
                        .concat(assuranceDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(assuranceDto));
    }
    @PostMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteAssuranceForId(
            @PathVariable(name = "id") final String id) {
        return assuranceService.deleteAssuranceForId(id)
                .map(message -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(message));

    }
}

