package com.spring.boot.Reactive.SpringBootReactive;

import java.time.Duration;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringBootReactiveApplicationTests {

	@Test
	void testMono() {
//		Mono<String> mono = Mono.just("Macbook");
//		mono.log().map(data->data.toUpperCase())
//		.subscribe(data->System.out.println(data));
//	you can use above or below both one are doing same thing
		Mono<String> mono = Mono.just("Macbook");
		mono.log().map(data->data.toUpperCase())
		.subscribe(System.out::println);
	}
	
	@Test
	void testFlux() throws InterruptedException {
//		Flux<String> flux = Flux.just("Macbook","Iphone","Airbuds");
//		flux.log().map(data->data.toUpperCase())
//		.subscribe(data->System.out.println(data));
		
		//you can use above or below both one are doing same thing

//		Flux.just("Macbook","Iphone","Airbuds").log().map(data->data.toUpperCase())
//		.subscribe(data->System.out.println(data));
		
		Flux.just("Macbook","Iphone","Airbuds","Macbook","Iphone","Airbuds")
		.delayElements(Duration.ofSeconds(2))
		.log().map(data->data.toUpperCase())
		.subscribe(new Subscriber<String>() {
			
			private long count = 0;
			private Subscription sub;

			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(String t) {
//				count++;
//				if(count >= 3) {
//					count = 0 ;
//					sub.request(3);
//				}
				System.out.println(t);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completely Done!!!");
			}
			
		});
		Thread.sleep(6000);
	}

}
