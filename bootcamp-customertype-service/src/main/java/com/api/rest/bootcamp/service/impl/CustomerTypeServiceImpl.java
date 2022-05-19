package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.CustomerType;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.CustomerTypeResponseDto;
import com.api.rest.bootcamp.exception.ResourceNotFoundException;
import com.api.rest.bootcamp.repository.CustomerTypeDao;
import com.api.rest.bootcamp.service.CustomerTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerTypeDao customerTypeDao;

    @Override
    public CustomerTypeResponseDto getAllCustomerType(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<CustomerType> customers = customerTypeDao.findAll(pageable);
        List<CustomerType> customerList = customers.getContent();
        List<CustomerTypeDto> content = customerList.stream().map(this::entitiesToDto).collect(Collectors.toList());
        CustomerTypeResponseDto customerDto = new CustomerTypeResponseDto();
        customerDto.setContentPage(content);
        customerDto.setPageNumber(customers.getNumber());
        customerDto.setAllElements(customers.getTotalElements());
        customerDto.setAllPages(customers.getTotalPages());
        customerDto.setLastPage(customers.isLast());
        return customerDto;
    }

    @Override
    public CustomerTypeDto getCustomerTypeForId(String id) {
        CustomerType customer = this.getCustomerTypeForIdUtil(id);
        return this.entitiesToDto(customer);
    }

    @Override
    public CustomerTypeDto createNewCustomerType(CustomerTypeDto customerTypeDto) {
        CustomerType customer = this.dtoToEntities(customerTypeDto);
        CustomerType newCustomer = this.customerTypeDao.save(customer);
        return this.entitiesToDto(newCustomer);
    }

    @Override
    public CustomerTypeDto updateCustomerTypeForId(CustomerTypeDto customerTypeDto, String id) {
        CustomerType customerType = this.getCustomerTypeForIdUtil(id);
        customerType.setCode(customerTypeDto.getCode());
        customerType.setCustomerType(customerTypeDto.getCustomerType());
        customerType.setDescription(customerTypeDto.getDescription());
        CustomerType updateCustomerType = this.customerTypeDao.save(customerType);
        return this.entitiesToDto(updateCustomerType);
    }

    @Override
    public void deleteCustomerTypeForId(String id) {
        CustomerType customer = this.getCustomerTypeForIdUtil(id);
        this.customerTypeDao.delete(customer);
    }

    private CustomerType getCustomerTypeForIdUtil(String id) {
        return customerTypeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer type", "id", id));
    }

    private CustomerTypeDto entitiesToDto(final CustomerType customerType) {
        CustomerTypeDto customerDto = this.modelMapper.map(customerType, CustomerTypeDto.class);
        return customerDto;
    }

    private CustomerType dtoToEntities(final CustomerTypeDto customerTypeDto) {
        CustomerType customerType = this.modelMapper.map(customerTypeDto, CustomerType.class);
        return customerType;
    }
}
