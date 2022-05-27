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
    /**
     * LOG PaymentServiceImpla.class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);
    /**
     * payemnt DAO.
     */
    @Autowired
    private PaymentDao paymentDao;

    /**
     * @return get all payments.
     */
    @Override
    public Flux<PaymentDto> getAllPayments() {
        return paymentDao.findAll().map(AppUtil::entityToDto);
    }

    /**
     * @param id
     * @return get payment for id.
     */
    @Override
    public Mono<PaymentDto> getPaymentForId(final String id) {
        return paymentDao.findById(id).map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new PaymentNotFoundException(id)));
    }

    /**
     * @param paymentDtoMono
     * @return save payment.
     */
    @Override
    public Mono<PaymentDto> savePayment(final Mono<PaymentDto> paymentDtoMono) {
        return paymentDtoMono.map(AppUtil::dtoToEntities)
                .flatMap(paymentDao::insert)
                .map(AppUtil::entityToDto);
    }

    /**
     * @param paymentDtoMono
     * @param id
     * @return update payment for id.
     */
    @Override
    public Mono<PaymentDto> updatePaymentForId(
            final Mono<PaymentDto> paymentDtoMono,
            final String id) {
        return paymentDao.findById(id)
                .flatMap(product -> paymentDtoMono.map(AppUtil::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(paymentDao::save)
                .map(AppUtil::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new PaymentNotFoundException(id)));
    }

    /**
     * @param id
     * @return delete payment for id.
     */
    @Override
    public Mono<String> deletePaymentForId(final String id) {
        return paymentDao.findById(id).flatMap(product ->
                this.paymentDao.deleteById(product.getId())
                .thenReturn("The Product has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new PaymentNotFoundException(id)));
    }
}
