package com.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MonoExample implements CommandLineRunner {
    /*
    Mono digunakan untuk menangani data tunggal (0 atau 1 item).
    Sangat cocok untuk operasi seperti mendapatkan satu nilai dari database, memanggil satu
    endpoint API, dll.
     */
    @Override
    public void run(String... args) throws Exception {
        Mono<String> content = Mono.just("Hello, WebFlux"); // Publisher
        content.log().subscribe(System.out::println); // Subscriber
    }
}
