package com.aravinth.spring.boot.restful.SpringBootRest.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aravinth.spring.boot.restful.SpringBootRest.Repositories.ProductRepo;
import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Product Rest Endpoint")
@RequestMapping("/products")
public class ProductController1{
	
	@Autowired
	ProductRepo repo;
	
	//localhost:8080/products/ -> select url use in postman
	@RequestMapping(value="/products/",method=RequestMethod.GET)
	@Hidden
	public List<Product> getProducts(){
		return (List<Product>) repo.findAll();		
	}
	
//	localhost:8080/products/products/9 
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	@Operation(summary="Returns a product",description="Takes Id return single product")
	public @ApiResponse(description="Product Object") Product getProduct(@Parameter(description="Id of the Product")@PathVariable("id") Integer id) {
		return repo.findById(id).get();
	}
	
	
//	insert,update you need pass data form postman request body->row->json
	//localhost:8080/products/ -> insert url use in postman
	@RequestMapping(value="/products/",method=RequestMethod.POST)
	public Product create1(@Valid @RequestBody Product product) {
		return repo.save(product);
	}
	
	//localhost:8080/products/ -> update url use in postman
	@RequestMapping(value="/products/",method=RequestMethod.PUT)
	public Product update(@RequestBody Product product) {
		return repo.save(product);
	}
	
	//localhost:8080/products/ -> update url use in postman
	@RequestMapping(value="/products/",method=RequestMethod.PATCH)
	public Product update1(@RequestBody Product product) {
		return repo.save(product);
	}
	
	
	//localhost:8080/products/products/9   -> delete url use in postman
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
