//package com.webflux;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.Disposable;
//import reactor.core.publisher.Mono;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@Slf4j
//public class WebClientExample implements CommandLineRunner {
//	@Override
//	public void run(String... args) throws Exception {
//		// Membuat instance secara langsung
//		WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");
//
//
//		List<String> responseList = new ArrayList<>();
//
//		// Melakukan GET request ke endpoint
//		Mono<String> response = webClient.get()
//			.uri("/posts/1")
//			.retrieve()
//			.bodyToMono(String.class);
//
//		response.subscribe(
//			result -> {
//				responseList.add(result);
//				log.info("Response: {}", result);
//			},
//			// callback jika terjadi error
//			error -> log.warn("Error: {}", error.getMessage()),
//			// callback ketika proses selesai
//			() -> log.info("Done")
//		);
//
//		try {
//			Thread.sleep(1000);
//		}catch (Exception e){
//			Thread.currentThread().interrupt();
//		}
//
//		log.info("Final response: {}", responseList);
//	}
//}
