package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.api.client.response.CustomerTypeResponse;
import com.api.rest.bootcamp.document.Customer;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.redis.model.CustomerTypeCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

public final class AppUtils {
    /**
     * @param customer
     * @return convert entities to dto.
     */
    public static CustomerDto entityToDto(final Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    /**
     * @param customerDto
     * @return convert dto to entities.
     */
    public static Customer dtoToEntities(final CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    /**
     *
     */
    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param customerTypeCache
     * @return customer type response.
     */
        public static CustomerTypeCache customerResponseToCache(final CustomerTypeResponse customerTypeResponse) {
        CustomerTypeCache customerTypeCache = new CustomerTypeCache();
        BeanUtils.copyProperties(customerTypeResponse, customerTypeCache);
        return customerTypeCache;
    }
    /**
     * constructor for default empty.
     */
    private AppUtils() {
    }
}
