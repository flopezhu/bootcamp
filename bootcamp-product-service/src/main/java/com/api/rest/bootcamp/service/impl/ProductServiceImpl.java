package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.document.error.ProductNotFoundException;
import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.repository.ProductDao;
import com.api.rest.bootcamp.service.ProductService;
import com.api.rest.bootcamp.util.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * LOG ProductServiceImpl.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(ProductServiceImpl.class);
    /**
     * product DAO.
     */
    @Autowired
    private ProductDao productDao;

    /**
     * @return get all products.
     */
    @Override
    public Flux<ProductDto> getAllProducts() {
        return productDao.findAll().map(AppUtils::entityToDto);
    }

    /**
     * @param id
     * @return get product for id.
     */
    @Override
    public Mono<ProductDto> getProductForId(final String id) {
        return productDao.findById(id)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new ProductNotFoundException(id)));
    }

    /**
     * @param productDtoMono
     * @return save product.
     */
    @Override
    public Mono<ProductDto> saveProduct(final Mono<ProductDto> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntities)
                .flatMap(productDao::insert)
                .map(AppUtils::entityToDto);
    }

    /**
     * @param productDtoMono
     * @param id
     * @return update product for id.
     */
    @Override
    public Mono<ProductDto> updateProductForId(
            final Mono<ProductDto> productDtoMono,
            final String id) {
        return productDao.findById(id)
                .flatMap(product -> productDtoMono.map(AppUtils::dtoToEntities))
                .doOnNext(idProduct -> idProduct.setId(id))
                .flatMap(productDao::save)
                .map(AppUtils::entityToDto)
                .switchIfEmpty(Mono.error(() ->
                        new ProductNotFoundException(id)));
    }

    /**
     * @param id
     * @return delete product for id.
     */
    @Override
    public Mono<String> deleteProductForId(final String id) {
        return productDao.findById(id).flatMap(product ->
                this.productDao.deleteById(product.getId())
                .thenReturn("The Product has deleted"))
                .switchIfEmpty(Mono.error(() ->
                        new ProductNotFoundException(id)));
    }
}
