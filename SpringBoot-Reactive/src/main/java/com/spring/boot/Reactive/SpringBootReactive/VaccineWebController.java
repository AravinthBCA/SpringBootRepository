package com.spring.boot.Reactive.SpringBootReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

public class VaccineWebController {
	
	@Autowired
	private VaccineService service;

	@GetMapping("/")
	public Mono<String> getVaccines(Model model) {
		model.addAttribute("vaccines", service.getVaccines());
		return Mono.just("index");

	}
	
}
