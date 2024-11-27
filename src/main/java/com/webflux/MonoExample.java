package com.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MonoExample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Mono<String> content = Mono.just("Hello, WebFlux"); // Publisher
        content.log().subscribe(System.out::println); // Subscriber
    }
}
