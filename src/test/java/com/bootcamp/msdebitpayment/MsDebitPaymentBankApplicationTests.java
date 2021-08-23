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
	void whenFindAll_thenReturnListDebitPayment() {

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

	/**
	 * Method validating a json path
	 */
	@Test
	void whenFindById_thenReturnMonoDebitPayment(){
		client.get()
				.uri("/api/debitPayment/{id}", Collections.singletonMap("id","6123458bbb00ff26e7eb1aff"))
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.originAccount").isEqualTo("19198789115082")
				.jsonPath("$.amount").isNotEmpty()
				.jsonPath("$.destinationCredit").isEqualTo("5637856547");
	}

}
