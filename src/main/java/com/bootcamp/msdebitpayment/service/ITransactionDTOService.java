package com.bootcamp.msdebitpayment.service;

import com.bootcamp.msdebitpayment.models.dto.TransactionDTO;
import reactor.core.publisher.Mono;

/**
 * The interface Transaction dto service.
 */
public interface ITransactionDTOService {
    /**
     * Save transaction mono.
     *
     * @param transaction the transaction
     * @return the mono
     */
    public Mono<TransactionDTO> saveTransaction(TransactionDTO transaction);
}
