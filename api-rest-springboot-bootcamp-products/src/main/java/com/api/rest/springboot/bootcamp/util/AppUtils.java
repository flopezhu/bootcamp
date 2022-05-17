package com.api.rest.springboot.bootcamp.util;

import com.api.rest.springboot.bootcamp.document.Product;
import com.api.rest.springboot.bootcamp.dto.ProductDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntities(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
