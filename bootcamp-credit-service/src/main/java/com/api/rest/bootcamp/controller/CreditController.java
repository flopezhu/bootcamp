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
    @Autowired
    private CreditService creditService;

    @GetMapping
    public Mono<ResponseEntity<Flux<CreditDto>>> getAllProducts() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(creditService.getAllCredits()));
        //return productService.getAllProducts().map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CreditDto>> getProductForId(@PathVariable(name = "id") String id) {
        return creditService.getCreditForId(id).map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<CreditDto>> registerProduct(@RequestBody Mono<CreditDto> productDtoMono) {
        return creditService.saveCredit(productDtoMono).map(productDto -> ResponseEntity.created(URI.create("/api/products".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @PutMapping("update/{id}")
    public Mono<ResponseEntity<CreditDto>> updateProduct(@RequestBody Mono<CreditDto> productDtoMono, @PathVariable(name = "id") String id) {
        return creditService.updateCreditForId(productDtoMono, id).map(productDto -> ResponseEntity.created(URI.create("/api/product".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable(name = "id") String id) {
        return creditService.deleteCreditForId(id).map(product -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(product));
    }
}
