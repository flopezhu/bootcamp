package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.PaymentNotFoundException;
import com.api.rest.bootcamp.dto.PaymentDto;
import com.api.rest.bootcamp.repository.PaymentDao;
import com.api.rest.bootcamp.service.PaymentService;
import com.api.rest.bootcamp.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Flux<PaymentDto> getAllPayments() {
        return paymentDao.findAll().map(AppUtil::entityToDto);
    }

    @Override
    public Mono<PaymentDto> getPaymentForId(String id) {
        return paymentDao.findById(id).map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() -> new PaymentNotFoundException(id)));
    }

    @Override
    public Mono<PaymentDto> savePayment(Mono<PaymentDto> paymentDtoMono) {
        return paymentDtoMono.map(AppUtil::dtoToEntities)
                .flatMap(paymentDao::insert)
                .map(AppUtil::entityToDto);
    }

    @Override
    public Mono<PaymentDto> updatePaymentForId(Mono<PaymentDto> paymentDtoMono, String id) {
        return paymentDao.findById(id)
                .flatMap(product -> paymentDtoMono.map(AppUtil::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(paymentDao::save)
                .map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() -> new PaymentNotFoundException(id)));
    }

    @Override
    public Mono<String> deletePaymentForId(String id) {
        return paymentDao.findById(id).flatMap(product -> this.paymentDao.deleteById(product.getId())
                .thenReturn("The Product has deleted")).switchIfEmpty(Mono.error(() -> new PaymentNotFoundException(id)));
    }
}
