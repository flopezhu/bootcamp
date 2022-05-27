package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.PaymentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {
    /**
     * @return get all payments.
     */
    Flux<PaymentDto> getAllPayments();

    /**
     * @param id
     * @return get payment for id.
     */
    Mono<PaymentDto> getPaymentForId(String id);

    /**
     * @param paymentDtoMono
     * @return save payment.
     */
    Mono<PaymentDto> savePayment(Mono<PaymentDto> paymentDtoMono);

    /**
     * @param paymentDtoMono
     * @param id
     * @return update payment for id.
     */
    Mono<PaymentDto> updatePaymentForId(Mono<PaymentDto> paymentDtoMono, String id);

    /**
     * @param id
     * @return delete payment for id.
     */
    Mono<String> deletePaymentForId(String id);
}
