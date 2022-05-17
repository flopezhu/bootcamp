package com.api.rest.springdata.bootcamp.service.impl;

import com.api.rest.springdata.bootcamp.dto.CustomerTypeDto;
import com.api.rest.springdata.bootcamp.dto.CustomerTypeResponseDto;
import com.api.rest.springdata.bootcamp.service.CustomerTypeService;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Override
    public CustomerTypeResponseDto getAllCustomerType(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public CustomerTypeDto getCustomerTypeForId(String id) {
        return null;
    }

    @Override
    public CustomerTypeDto createNewCustomerType(CustomerTypeDto customerTypeDto) {
        return null;
    }

    @Override
    public CustomerTypeDto updateCustomerTypeForId(CustomerTypeDto customerTypeDto, String id) {
        return null;
    }

    @Override
    public void deleteCustomerTypeForId(String id) {
    }
}
