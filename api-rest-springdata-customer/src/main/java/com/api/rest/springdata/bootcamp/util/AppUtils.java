package com.api.rest.springdata.bootcamp.util;

import com.api.rest.springdata.bootcamp.document.Customer;
import com.api.rest.springdata.bootcamp.document.Product;
import com.api.rest.springdata.bootcamp.dto.CustomerDto;
import com.api.rest.springdata.bootcamp.dto.ProductDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static CustomerDto customerEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer customerDtoToEntities(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    public static ProductDto productEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product productDtoToEntities(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
