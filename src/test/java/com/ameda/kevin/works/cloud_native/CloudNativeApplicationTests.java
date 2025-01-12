package com.ameda.kevin.works.cloud_native;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudNativeApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenGetRootThenReturnMessage(){
		webTestClient.get()
				.uri("/")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("Kevin Ameda Kisevu is a senior Java Developer with Java");

	}

}
