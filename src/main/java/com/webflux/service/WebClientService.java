package com.webflux.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@Slf4j
public class WebClientService {

	private final WebClient webClient;

	public WebClientService(WebClient.Builder webClient) {
		this.webClient = webClient.baseUrl("https://jsonplaceholder.typicode.com").build();
	}

	public Mono<String> webfluxService() {
			return webClient.get()
				.uri("/posts/1")
				.retrieve()
				.onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.just(new RuntimeException("Client error occurred")))
				.onStatus(HttpStatusCode::is5xxServerError, serverResponse -> Mono.just(new RuntimeException("Server error occurred")))
				.bodyToMono(String.class)
				.timeout(Duration.ofSeconds(20));
			}

}
