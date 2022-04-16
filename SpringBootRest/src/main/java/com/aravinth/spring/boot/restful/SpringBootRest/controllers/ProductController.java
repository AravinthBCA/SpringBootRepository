package com.aravinth.spring.boot.restful.SpringBootRest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravinth.spring.boot.restful.SpringBootRest.Repositories.ProductRepo;
import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@GetMapping
	public Iterable<Product> getProducts(){
		return repo.findAll();		
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@PatchMapping
	public Product create1(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@PutMapping
	public Product update(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Integer id) {
		return repo.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
