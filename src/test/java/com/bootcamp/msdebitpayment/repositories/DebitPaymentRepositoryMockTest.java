package com.bootcamp.msdebitpayment.repositories;

import com.bootcamp.msdebitpayment.models.entities.DebitPayment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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

//    @Test
//    public void whenSave_thenValidateDebitPayment(){
//        repository.save(DebitPayment.builder().id("12345").originAccount("19198789115082")
//                .originTypeOfAccount("SAVING_ACCOUNT")
//                .amount(125.0).destinationCredit("5637856547")
//                .destinationTypeOfCredit("CREDIT").build()).subscribe();
//
//        Mono<DebitPayment> debitPayment = repository.findById("12345");
//
//        StepVerifier.create(debitPayment).expectNext(DebitPayment.builder().id("12345").originAccount("19198789115082")
//                .originTypeOfAccount("SAVING_ACCOUNT")
//                .amount(125.0).destinationCredit("5637856547")
//                .destinationTypeOfCredit("CREDIT").build()).verifyComplete();
//    }
}
