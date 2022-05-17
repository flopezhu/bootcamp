package com.api.rest.springdata.bootcamp.service.impl;

import com.api.rest.springdata.bootcamp.document.Customer;
import com.api.rest.springdata.bootcamp.document.Product;
import com.api.rest.springdata.bootcamp.dto.CustomerDto;
import com.api.rest.springdata.bootcamp.dto.CustomerResponseDto;
import com.api.rest.springdata.bootcamp.dto.ProductDto;
import com.api.rest.springdata.bootcamp.dto.ProductResponseDto;
import com.api.rest.springdata.bootcamp.exceptions.ResourceNotFoundException;
import com.api.rest.springdata.bootcamp.repository.ProductDao;
import com.api.rest.springdata.bootcamp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductDao productDao;

    @Override
    public ProductResponseDto getAllProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> products = productDao.findAll(pageable);
        List<Product> productList = products.getContent();
        List<ProductDto> content = productList.stream().map(this::entitiesToDto).collect(Collectors.toList());
        ProductResponseDto customerDto = new ProductResponseDto();
        customerDto.setContentPage(content);
        customerDto.setPageNumber(products.getNumber());
        customerDto.setAllElements(products.getTotalElements());
        customerDto.setAllPages(products.getTotalPages());
        customerDto.setLastPage(products.isLast());
        return customerDto;
    }

    @Override
    public ProductDto getProductForId(String id) {
        return null;
    }

    @Override
    public ProductDto createNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProductForId(ProductDto productDto, String id) {
        return null;
    }

    @Override
    public void deleteProductForId(String id) {
    }

    private Product getProductsForIdUtil(String id) {
        return productDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    private ProductDto entitiesToDto(final Product product) {
        ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    private Product dtoToEntities(final ProductDto productDto) {
        Product product  = this.modelMapper.map(productDto, Product.class);
        return product;
    }

}
