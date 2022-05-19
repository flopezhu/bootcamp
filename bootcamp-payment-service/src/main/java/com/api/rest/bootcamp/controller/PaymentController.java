package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.PaymentDto;
import com.api.rest.bootcamp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public Mono<ResponseEntity<Flux<PaymentDto>>> getAllProducts() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(paymentService.getAllPayments()));
        //return productService.getAllProducts().map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PaymentDto>> getProductForId(@PathVariable(name = "id") String id) {
        return paymentService.getPaymentForId(id).map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<PaymentDto>> registerProduct(@RequestBody Mono<PaymentDto> productDtoMono) {
        return paymentService.savePayment(productDtoMono).map(productDto -> ResponseEntity.created(URI.create("/api/products".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @PutMapping("update/{id}")
    public Mono<ResponseEntity<PaymentDto>> updateProduct(@RequestBody Mono<PaymentDto> productDtoMono, @PathVariable(name = "id") String id) {
        return paymentService.updatePaymentForId(productDtoMono, id).map(productDto -> ResponseEntity.created(URI.create("/api/product".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable(name = "id") String id) {
        return paymentService.deletePaymentForId(id).map(product -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(product));
    }
}
