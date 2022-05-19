package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.PaymentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Flux<PaymentDto> getAllPayments();

    Mono<PaymentDto> getPaymentForId(String id);

    Mono<PaymentDto> savePayment(Mono<PaymentDto> paymentDtoMono);

    Mono<PaymentDto> updatePaymentForId(Mono<PaymentDto> paymentDtoMono, String id);

    Mono<String> deletePaymentForId(String id);
}
