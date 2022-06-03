package com.api.rest.bootcamp.service;

import com.api.rest.bootcamp.dto.CustomerTypeDto;
import com.api.rest.bootcamp.model.Transaction;

public interface TransactionService {
    String processTransaction(Transaction transaction) throws InterruptedException;
}
