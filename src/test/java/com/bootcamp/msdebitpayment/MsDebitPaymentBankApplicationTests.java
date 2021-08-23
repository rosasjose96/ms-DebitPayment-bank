package com.bootcamp.msdebitpayment;

import com.bootcamp.msdebitpayment.models.entities.DebitPayment;
import com.bootcamp.msdebitpayment.repositories.DebitPaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class MsDebitPaymentBankApplicationTests {

	@Autowired
	private WebTestClient client;

	@Test
	void contextLoads() {

		client.get()
				.uri("/api/debitPayment")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBodyList(DebitPayment.class)
				.hasSize(6);
	}

	@Test
	void whenFindAllByOriginAccount_thenReturnListDebitPayment(){
		client.get()
				.uri("/api/debitPayment/origin/{originAccount}", Collections.singletonMap("originAccount","19198789115082"))
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBodyList(DebitPayment.class)
				.hasSize(3);
	}

}
