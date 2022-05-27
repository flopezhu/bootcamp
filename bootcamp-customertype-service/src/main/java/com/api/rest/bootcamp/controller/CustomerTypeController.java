package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.dto.CustomerTypeResponseDto;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/customerType")
public class CustomerTypeController {
    /**
     * customer type service.
     */
    @Autowired
    private CustomerTypeService customerTypeService;

    /**
     * @param pageNumber
     * @param pageSize
     * @return get all customer type.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerTypeResponseDto> getAllCustomerType(
            @RequestParam(value = "pageNumber", defaultValue = AppConstant.
                    NUMBER_PAGE_FOR_DEFAULT, required = false)
            final int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.
                    SIZE_PAGE_FOR_DEFAULT, required = false)
            final int pageSize) {
        return ResponseEntity.ok(this.customerTypeService
                .getAllCustomerType(pageNumber, pageSize));
    }

    /**
     * @param customerDto
     * @return create a new customer type.
     */
    @PostMapping(value = "/create")
    public ResponseEntity<CustomerTypeDto> createNewCustomerType(
            @Valid @RequestBody final CustomerTypeDto customerDto) {
        return new ResponseEntity<>(this.customerTypeService
                .createNewCustomerType(customerDto), HttpStatus.CREATED);
    }

    /**
     * @param customerDto
     * @param id
     * @return update customer type for id.
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerTypeDto> updateCustomerTypeForId(
            @RequestBody final CustomerTypeDto customerDto,
            @PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(this.customerTypeService
                .updateCustomerTypeForId(customerDto, id), HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return get customer type for id.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerTypeDto> getCustomerTypeForId(
            @PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(this.customerTypeService
                .getCustomerTypeForId(id), HttpStatus.OK);
    }

    /**
     * @param id
     * @return delete customer type for id.
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomerTypeById(
            @PathVariable(name = "id") final String id) {
        this.customerTypeService.deleteCustomerTypeForId(id);
        return new ResponseEntity<>("Customer has deleted", HttpStatus.OK);
    }
}
