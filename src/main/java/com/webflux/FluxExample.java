package com.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FluxExample implements CommandLineRunner {
    /*
    Flux digunakan untuk menangani banyak data (0 hingga N item).
    Cocok untuk streaming data atau daftar item.
     */
    @Override
    public void run(String... args) throws Exception {
        Flux<Integer> numbers = Flux.range(1, 5); // Publisher
        numbers.log().subscribe(System.out::println); // Subscriber

        Flux<String> fruits = Flux.just("Apple", "Banana", "Orange");
        fruits.log().subscribe(System.out::println);

        /*
        map()   -> transformasi sederhana dari satu nilai ke nilai lain
        case    -> mengalikan setiap element dengan 2 dan menghitung length string
         */
        Flux<Integer> numbers1 = Flux.range(1, 3)
            .map(n -> n * 2);
        numbers1.log().subscribe(System.out::println);

        Flux<Integer> numbers2 = Flux.just("Apple", "Banana")
            .map(n -> n.length());
        numbers2.log().subscribe(System.out::println);

        /*
        flatMap()   -> Digunakan ketika Anda perlu mengubah setiap item menjadi Publisher.
        case        -> Mengambil setiap nama dan menjadikan sebagai Mono Publisher
         */
        Flux<String> names = Flux.just("Asep", "Dudung")
            .flatMap(name -> Mono.just("Hello " + name));
        names.log().subscribe(System.out::println);

        /*
        filter()    -> mendapatkan item berdasarkan kondisi tertentu
        case        -> mendaptakan bilangan yang hanya habis di bagi 2(Bilangan Genap)
         */
        Flux<Integer> numbers3 = Flux.range(1, 10)
            .filter(n -> n % 2 == 0);
        numbers3.log().subscribe(res -> System.out.println(res));

        /*
        zip()       -> Menggabungkan dua Publisher menjadi satu Publisher baru.
        case        -> Menggabungkan Publisher num4 dan num5 menjadi A4,B5,C6
         */
        Flux<String> numbers4 = Flux.just("A", "B", "C");
        Flux<Integer> numbers5 = Flux.just(4, 5, 6);
        Flux<String> zip = Flux.zip(numbers4, numbers5, (a, b) -> a + b);
        zip.log().subscribe(System.out::println);

        /*
        doOnNext()  -> Digunakan untuk process selanjutnya, seperti logging.
        case        -> Mengeluarkan logging "process"
         */
        Flux<Integer> numbers6 = Flux.range(1, 3)
            .doOnNext(n -> System.out.println("process: " + n));
        numbers6.log().subscribe(System.out::println);
    }
}
