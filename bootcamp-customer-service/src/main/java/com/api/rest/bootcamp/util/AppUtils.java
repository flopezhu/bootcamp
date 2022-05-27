package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Customer;
import com.api.rest.bootcamp.dto.CustomerDto;
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
     * constructor for default empty.
     */
    private AppUtils() { }
}
