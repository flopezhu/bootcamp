package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Product;
import com.api.rest.bootcamp.dto.ProductDto;
import org.springframework.beans.BeanUtils;

public final class AppUtils {
    /**
     * @param product
     * @return convert entities to dto.
     */
    public static ProductDto entityToDto(final Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    /**
     * @param productDto
     * @return convert dto to entities.
     */
    public static Product dtoToEntities(final ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    /**
     * empty constructor
     */
    private AppUtils() { }
}
