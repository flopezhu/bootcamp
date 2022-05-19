package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Payment;
import com.api.rest.bootcamp.dto.PaymentDto;
import org.springframework.beans.BeanUtils;

public class AppUtil {
    public static PaymentDto entityToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        BeanUtils.copyProperties(payment, paymentDto);
        return paymentDto;
    }

    public static Payment dtoToEntities(PaymentDto paymentDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        return payment;
    }
}
