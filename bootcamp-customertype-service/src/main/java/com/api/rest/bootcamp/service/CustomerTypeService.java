package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.CustomerTypeResponseDto;

public interface CustomerTypeService {
    /**
     * @param pageNumber
     * @param pageSize
     * @return get all customers type.
     */
    CustomerTypeResponseDto getAllCustomerType(int pageNumber, int pageSize);

    /**
     * @param id
     * @return get customer type for id.
     */
    CustomerTypeDto getCustomerTypeForId(String id);

    /**
     * @param customerTypeDto
     * @return create a new customer type.
     */
    CustomerTypeDto createNewCustomerType(CustomerTypeDto customerTypeDto);

    /**
     * @param customerTypeDto
     * @param id
     * @return update customer type for id.
     */
    CustomerTypeDto updateCustomerTypeForId(CustomerTypeDto customerTypeDto, String id);

    /**
     * @param id
     */
    void deleteCustomerTypeForId(String id);
}
