package com.bootcamp.msdebitpayment.repositories;

import com.bootcamp.msdebitpayment.models.entities.DebitPayment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface DebitPaymentRepository extends ReactiveMongoRepository<DebitPayment,String> {

    Flux<DebitPayment> findAllByOriginAccount (String originAccount);
}
