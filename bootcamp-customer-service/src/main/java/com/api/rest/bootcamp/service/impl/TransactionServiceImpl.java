package com.api.rest.bootcamp.service.impl;

import com.api.rest.bootcamp.api.client.CustomerTypeApiClient;
import com.api.rest.bootcamp.model.Transaction;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.TransactionService;
import com.api.rest.bootcamp.util.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private CustomerTypeApiClient customerTypeApiClient;

    /**
     * @param transaction
     * @return save transaction in redis.
     * @throws InterruptedException
     */
    @Override
    public String processTransaction(final Transaction transaction)
            throws InterruptedException {
        if (customerTypeService.getAllCustomerType().isEmpty()) {
            customerTypeService.storageCustomerTypeList(
                    customerTypeApiClient.getAllCustomerType()
                            .stream()
                            .map(AppUtils::customerResponseToCache)
                            .collect(Collectors.toList())
            );
        }
        log.info("From Redis cache " + customerTypeService
                .getAllCustomerType().toString());
        return "Processing Draft...";
    }
}
