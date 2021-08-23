package com.bootcamp.msdebitpayment.repositories;

import com.bootcamp.msdebitpayment.models.entities.DebitPayment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@DataMongoTest
public class DebitPaymentRepositoryMockTest {

    @Autowired
    private DebitPaymentRepository repository;

    @Test
    public void whenFindAllByOriginAccount_thenReturnListDebitPayment(){

        Flux<DebitPayment> founds = repository.findAllByOriginAccount("19198789115082");
        StepVerifier.create(founds.log()).expectNextCount(3).verifyComplete();
    }

    @Test
    public void whenFindAll_thenReturnListDebitPayment(){
        Flux<DebitPayment> founds = repository.findAll();
        StepVerifier.create(founds.log()).expectNextCount(6).verifyComplete();
    }
}
