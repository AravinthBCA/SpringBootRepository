package com.spring.boot.Reactive.SpringBootReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class VaccineController {

	@Autowired
	private VaccineService service;

	@GetMapping(value="/vaccines",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Vaccine> getVaccines() {
		return service.getVaccines();
	}
	
}
