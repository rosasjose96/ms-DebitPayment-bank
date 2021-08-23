package com.bootcamp.msdebitpayment.service;

import com.bootcamp.msdebitpayment.models.entities.DebitPayment;
import reactor.core.publisher.Flux;

public interface IDebitPaymentService extends ICRUDService<DebitPayment,String>{

    Flux<DebitPayment> findAllByOriginAccount (String originAccount);
}
