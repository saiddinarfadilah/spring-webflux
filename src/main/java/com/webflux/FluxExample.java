package com.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class FluxExample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Flux<Integer> numbers = Flux.range(1, 5); // Publisher
        numbers.log().subscribe(System.out::println); // Subscriber



    }
}
