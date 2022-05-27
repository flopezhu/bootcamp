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
    /**
     * payment service.
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * @return get all payments.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<PaymentDto>>> getAllPayments() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(paymentService.getAllPayments()));
    }

    /**
     * @param id
     * @return get payment for id.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<PaymentDto>> getPaymentForId(
            @PathVariable(name = "id") final String id) {
        return paymentService.getPaymentForId(id)
                .map(productDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productDto));
    }

    /**
     * @param productDtoMono
     * @return save payment.
     */
    @PostMapping("/register")
    public Mono<ResponseEntity<PaymentDto>> savePayment(
            @RequestBody final Mono<PaymentDto> productDtoMono) {
        return paymentService.savePayment(productDtoMono)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/products"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param productDtoMono
     * @param id
     * @return update payment for id.
     */
    @PutMapping("update/{id}")
    public Mono<ResponseEntity<PaymentDto>> updatePaymentForId(
            @RequestBody final Mono<PaymentDto> productDtoMono,
            @PathVariable(name = "id") final String id) {
        return paymentService.updatePaymentForId(productDtoMono, id)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/product"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param id
     * @return delete payment for id.
     */
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deletePaymentForId(
            @PathVariable(name = "id") final String id) {
        return paymentService.deletePaymentForId(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }
}
