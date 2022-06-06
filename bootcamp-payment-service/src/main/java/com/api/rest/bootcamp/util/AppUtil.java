package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Payment;
import com.api.rest.bootcamp.dto.PaymentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

public final class AppUtil {
    /**
     * @param payment
     * @return convert entities to dto.
     */
    public static PaymentDto entityToDto(final Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        BeanUtils.copyProperties(payment, paymentDto);
        return paymentDto;
    }

    /**
     * @param paymentDto
     * @return convert dto to entities.
     */
    public static Payment dtoToEntities(final PaymentDto paymentDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        return payment;
    }
    /**
     * object mapper.
     */
    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * private constructor empty for default.
     */
    private AppUtil() { }
}
