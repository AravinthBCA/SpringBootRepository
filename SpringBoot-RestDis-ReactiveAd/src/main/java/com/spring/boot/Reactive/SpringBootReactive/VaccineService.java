package com.spring.boot.Reactive.SpringBootReactive;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class VaccineService {
	
	public List<Vaccine> getVaccinesNormal(){
		return IntStream.rangeClosed(1,10)
				.peek(VaccineService::sleepExecution)
				.peek(i->System.out.println("Processing Count : "+i))
				.mapToObj(i->new Vaccine("Covid"))
				.collect(Collectors.toList());
	}
	
	public Flux<Vaccine> getVaccines() {
		return Flux.range(1,10)
				.delayElements(Duration.ofSeconds(3))
				.doOnNext(i -> System.out.println("Processing Count is Stream flow : "+i))
				.map(i -> new Vaccine("Pfizer"));

	}

	private static void sleepExecution(int int1) {
		try{
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
