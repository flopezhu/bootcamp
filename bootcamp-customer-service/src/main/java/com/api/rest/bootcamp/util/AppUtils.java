package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Customer;
import com.api.rest.bootcamp.dto.CustomerDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer dtoToEntities(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
