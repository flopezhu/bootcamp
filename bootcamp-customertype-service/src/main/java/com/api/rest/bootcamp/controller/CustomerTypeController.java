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
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerTypeResponseDto> getAllCustomer(@RequestParam(value = "pageNumber", defaultValue = AppConstant.NUMBER_PAGE_FOR_DEFAULT, required = false) int pageNumber,
                                                                  @RequestParam(value = "pageSize", defaultValue = AppConstant.SIZE_PAGE_FOR_DEFAULT, required = false) int pageSize) {
        return ResponseEntity.ok(this.customerTypeService.getAllCustomerType(pageNumber, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerTypeDto> createNewCustomer(@Valid @RequestBody CustomerTypeDto customerDto) {
        return new ResponseEntity<>(this.customerTypeService.createNewCustomerType(customerDto), HttpStatus.CREATED);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerTypeDto> updateCustomer(@RequestBody CustomerTypeDto customerDto,
                                                      @PathVariable(name = "id") String id) {
        return new ResponseEntity<>(this.customerTypeService.updateCustomerTypeForId(customerDto, id), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerTypeDto> getCustomerForId(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(this.customerTypeService.getCustomerTypeForId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") String id) {
        this.customerTypeService.deleteCustomerTypeForId(id);
        return new ResponseEntity<>("Customer has deleted", HttpStatus.OK);
    }
}
