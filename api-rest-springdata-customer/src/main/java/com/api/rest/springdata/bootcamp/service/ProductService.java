package com.api.rest.springdata.bootcamp.service;

import com.api.rest.springdata.bootcamp.document.Product;
import com.api.rest.springdata.bootcamp.dto.ProductDto;
import com.api.rest.springdata.bootcamp.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getAllProducts(int pageNumber, int pageSize);

    ProductDto getProductForId(String id);

    ProductDto createNewProduct(ProductDto productDto);

    ProductDto updateProductForId(ProductDto productDto, String id);

    void deleteProductForId(String id);
}
