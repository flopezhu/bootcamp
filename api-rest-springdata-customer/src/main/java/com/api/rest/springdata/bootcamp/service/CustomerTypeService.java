package com.api.rest.springdata.bootcamp.service;

import com.api.rest.springdata.bootcamp.dto.CustomerTypeDto;
import com.api.rest.springdata.bootcamp.dto.CustomerTypeResponseDto;

public interface CustomerTypeService {
    CustomerTypeResponseDto getAllCustomerType(int pageNumber, int pageSize);

    CustomerTypeDto getCustomerTypeForId(String id);

    CustomerTypeDto createNewCustomerType(CustomerTypeDto customerTypeDto);

    CustomerTypeDto updateCustomerTypeForId(CustomerTypeDto customerTypeDto, String id);

    void deleteCustomerTypeForId(String id);
}
