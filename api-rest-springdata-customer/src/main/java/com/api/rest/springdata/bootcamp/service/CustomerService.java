package com.api.rest.springdata.bootcamp.service;

import com.api.rest.springdata.bootcamp.document.Customer;
import com.api.rest.springdata.bootcamp.dto.CustomerDto;
import com.api.rest.springdata.bootcamp.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto getAllCustomers(int pageNumber, int pageSize);

    CustomerDto getCustomerForId(String id);

    CustomerDto createNewCustomer(CustomerDto customerDto);

    CustomerDto updateCustomerForId(CustomerDto customerDto, String id);

    void deleteCustomerForId(String id);
}
