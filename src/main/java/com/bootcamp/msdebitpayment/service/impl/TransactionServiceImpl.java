package com.bootcamp.msdebitpayment.service.impl;

import com.bootcamp.msdebitpayment.models.dto.TransactionDTO;
import com.bootcamp.msdebitpayment.service.ITransactionDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * The type Transaction active service.
 */
@Service
public class TransactionServiceImpl implements ITransactionDTOService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    @Qualifier
    private WebClient.Builder webClientBuilder;

    @Override
    public Mono<TransactionDTO> saveTransaction(TransactionDTO transaction) {
        LOGGER.info("initializing Transaction create");

        return webClientBuilder
                .baseUrl("http://TRANSACTION-SERVICE/api/transaction")
                .build()
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(TransactionDTO.class);
    }

}
