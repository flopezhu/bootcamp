package com.api.rest.springdata.bootcamp.service.impl;

import com.api.rest.springdata.bootcamp.document.Customer;
import com.api.rest.springdata.bootcamp.dto.CustomerDto;
import com.api.rest.springdata.bootcamp.dto.CustomerResponseDto;
import com.api.rest.springdata.bootcamp.dto.CustomerTypeDto;
import com.api.rest.springdata.bootcamp.exceptions.ResourceNotFoundException;
import com.api.rest.springdata.bootcamp.repository.CustomerDao;
import com.api.rest.springdata.bootcamp.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public CustomerResponseDto getAllCustomers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Customer> customers = customerDao.findAll(pageable);
        List<Customer> customerList = customers.getContent();
        List<CustomerDto> content = customerList.stream().map(this::entitiesToDto).collect(Collectors.toList());
        CustomerResponseDto customerDto = new CustomerResponseDto();
        customerDto.setContentPage(content);
        customerDto.setPageNumber(customers.getNumber());
        customerDto.setAllElements(customers.getTotalElements());
        customerDto.setAllPages(customers.getTotalPages());
        customerDto.setLastPage(customers.isLast());
        return customerDto;
    }

    @Override
    public CustomerDto getCustomerForId(String id) {
        Customer customer = this.getCustomerForIdUtil(id);
        return this.entitiesToDto(customer);
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        Customer customer = this.dtoToEntities(customerDto);
        Customer newCustomer = customerDao.save(customer);
        return this.entitiesToDto(newCustomer);
    }

    @Override
    public CustomerDto updateCustomerForId(CustomerDto customerDto, String id) {
        Customer customer = this.getCustomerForIdUtil(id);
        customer.setName(customerDto.getName());
        customer.setLastName(customerDto.getLastName());
        customer.setSex(customerDto.getSex());
        customer.setDateBirth(customerDto.getDateBirth());
        customer.setDocumentType(customerDto.getDocumentType());
        customer.setDocumentNumber(customerDto.getDocumentNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setCustomerTypeList(customerDto.getCustomerTypeList());
        customer.setProductList(customerDto.getProductList());
        Customer updateCustomer = customerDao.save(customer);
        return this.entitiesToDto(updateCustomer);
    }

    @Override
    public void deleteCustomerForId(String id) {
        Customer customer = getCustomerForIdUtil(id);
        customerDao.delete(customer);
    }

    private Customer getCustomerForIdUtil(String id) {
        return customerDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    private CustomerDto entitiesToDto(final Customer customer) {
        CustomerDto customerDto = this.modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    private Customer dtoToEntities(final CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        return customer;
    }


}
