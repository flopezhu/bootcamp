package com.api.rest.springdata.bootcamp.controller;

import com.api.rest.springdata.bootcamp.document.Customer;
import com.api.rest.springdata.bootcamp.dto.CustomerDto;
import com.api.rest.springdata.bootcamp.dto.CustomerResponseDto;
import com.api.rest.springdata.bootcamp.repository.CustomerDao;
import com.api.rest.springdata.bootcamp.service.CustomerService;
import com.api.rest.springdata.bootcamp.util.AppConstant;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerResponseDto> getAllCustomer(@RequestParam(value = "pageNumber", defaultValue = AppConstant.NUMBER_PAGE_FOR_DEFAULT, required = false) int pageNumber,
                                                              @RequestParam(value = "pageSize", defaultValue = AppConstant.SIZE_PAGE_FOR_DEFAULT, required = false) int pageSize) {
        return ResponseEntity.ok(customerService.getAllCustomers(pageNumber, pageSize));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.createNewCustomer(customerDto), HttpStatus.CREATED);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                                      @PathVariable(name = "id") String id) {
        return new ResponseEntity<>(customerService.updateCustomerForId(customerDto, id), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerForId(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(customerService.getCustomerForId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") String id) {
        customerService.deleteCustomerForId(id);
        return new ResponseEntity<>("Customer has deleted", HttpStatus.OK);
    }

}
