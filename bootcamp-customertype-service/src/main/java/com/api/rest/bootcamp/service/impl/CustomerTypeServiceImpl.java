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
    /**
     * model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * customer type dao.
     */
    @Autowired
    private CustomerTypeDao customerTypeDao;

    /**
     * @param pageNumber
     * @param pageSize
     * @return get all customers for page.
     */
    @Override
    public CustomerTypeResponseDto getAllCustomerType(final int pageNumber,
                                                      final int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<CustomerType> customers = customerTypeDao.findAll(pageable);
        List<CustomerType> customerList = customers.getContent();
        List<CustomerTypeDto> content = customerList.stream()
                .map(this::entitiesToDto).collect(Collectors.toList());
        CustomerTypeResponseDto customerDto = new CustomerTypeResponseDto();
        customerDto.setContentPage(content);
        customerDto.setPageNumber(customers.getNumber());
        customerDto.setAllElements(customers.getTotalElements());
        customerDto.setAllPages(customers.getTotalPages());
        customerDto.setLastPage(customers.isLast());
        return customerDto;
    }

    /**
     * @param id
     * @return get customer type for id.
     */
    @Override
    public CustomerTypeDto getCustomerTypeForId(final String id) {
        CustomerType customer = this.getCustomerTypeForIdUtil(id);
        return this.entitiesToDto(customer);
    }

    /**
     * @param customerTypeDto
     * @return create a new customer type.
     */
    @Override
    public CustomerTypeDto createNewCustomerType(
            final CustomerTypeDto customerTypeDto) {
        CustomerType customer = this.dtoToEntities(customerTypeDto);
        CustomerType newCustomer = this.customerTypeDao.save(customer);
        return this.entitiesToDto(newCustomer);
    }

    /**
     * @param customerTypeDto
     * @param id
     * @return update customer type for id.
     */
    @Override
    public CustomerTypeDto updateCustomerTypeForId(
            final CustomerTypeDto customerTypeDto,
            final String id) {
        CustomerType customerType = this.getCustomerTypeForIdUtil(id);
        customerType.setCode(customerTypeDto.getCode());
        customerType.setCustomerType(customerTypeDto.getCustomerType());
        customerType.setDescription(customerTypeDto.getDescription());
        CustomerType updateCustomerType = this.customerTypeDao
                .save(customerType);
        return this.entitiesToDto(updateCustomerType);
    }

    /**
     * @param id
     */
    @Override
    public void deleteCustomerTypeForId(final String id) {
        CustomerType customer = this.getCustomerTypeForIdUtil(id);
        this.customerTypeDao.delete(customer);
    }

    /**
     * @param id
     * @return valid if there's customer type.
     */
    private CustomerType getCustomerTypeForIdUtil(final String id) {
        return customerTypeDao.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer type", "id", id));
    }

    /**
     * @param customerType
     * @return convert entities to dto.
     */
    private CustomerTypeDto entitiesToDto(final CustomerType customerType) {
        return this.modelMapper.map(customerType, CustomerTypeDto.class);
    }

    /**
     * @param customerTypeDto
     * @return convert dto to entities.
     */
    private CustomerType dtoToEntities(final CustomerTypeDto customerTypeDto) {
        return this.modelMapper.map(customerTypeDto, CustomerType.class);
    }
}
