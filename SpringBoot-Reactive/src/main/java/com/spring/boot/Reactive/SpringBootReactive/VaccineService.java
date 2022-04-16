package com.spring.boot.Reactive.SpringBootReactive;

import java.time.Duration;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class VaccineService {
	public Flux<Vaccine> getVaccines() {
		return Flux.range(1,10)
				.delayElements(Duration.ofSeconds(3))
				.doOnNext(i -> System.out.println("Processing Count is Stream flow : "+i))
				.map(i -> new Vaccine("Pfizer"));
//        return Flux.range(1,5)
//                .delayElements(Duration.ofSeconds(1))
//                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
//                .map(i -> new Customer(i,"Customer "+i));
	}	
}
