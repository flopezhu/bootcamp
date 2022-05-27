package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.CreditDto;
import com.api.rest.bootcamp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/credit")
public class CreditController {
    /**
     * credit service.
     */
    @Autowired
    private CreditService creditService;

    /**
     * @return get all credits.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<CreditDto>>> getAllCredits() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(creditService.getAllCredits()));
    }

    /**
     * @param id
     * @return get credit for id.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<CreditDto>> getCreditForId(
            @PathVariable(name = "id") final String id) {
        return creditService.getCreditForId(id)
                .map(productDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productDto));
    }

    /**
     * @param productDtoMono
     * @return save credit.
     */
    @PostMapping("/register")
    public Mono<ResponseEntity<CreditDto>> saveCredit(
            @RequestBody final Mono<CreditDto> productDtoMono) {
        return creditService.saveCredit(productDtoMono)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/products"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param productDtoMono
     * @param id
     * @return update credit for id.
     */
    @PutMapping("update/{id}")
    public Mono<ResponseEntity<CreditDto>> updateCreditForId(
            @RequestBody final Mono<CreditDto> productDtoMono,
            @PathVariable(name = "id") final String id) {
        return creditService.updateCreditForId(productDtoMono, id)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/product"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param id
     * @return delete credit for id.
     */
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(
            @PathVariable(name = "id") final String id) {
        return creditService.deleteCreditForId(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }
}
