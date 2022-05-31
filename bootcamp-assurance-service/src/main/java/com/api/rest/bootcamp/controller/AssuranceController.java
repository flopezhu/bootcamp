package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.AssuranceResponse;
import com.api.rest.bootcamp.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/assurance")
public class AssuranceController {
    /**
     * bank fee service.
     */
    @Autowired
    private AssuranceService assuranceService;

    @GetMapping
    public Mono<ResponseEntity<Flux<AssuranceResponse>>> findAllAssurance() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(assuranceService.getAllAssuranceResponse()));
    }
}

