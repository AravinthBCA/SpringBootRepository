package com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Controllers;

import java.time.Duration;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Entities.Product;
import com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Repos.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	@PostMapping
	public Mono<Product> addProduct(@RequestBody Product product){
		return repo.save(product);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getProducts(){
		 Flux<Product> emps = repo.findAll();
		 return emps;
	}
}




