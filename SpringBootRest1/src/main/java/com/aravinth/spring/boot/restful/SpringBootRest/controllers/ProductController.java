package com.aravinth.spring.boot.restful.SpringBootRest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aravinth.spring.boot.restful.SpringBootRest.Repositories.ProductRepo;
import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Product RestApi Endpoints")
public class ProductController{
	
	@Autowired
	ProductRepo repo;
	
	//localhost:8080/products/ -> select url use in postman
	@Operation(summary="Returning all products",description="Retrieve all products")
	@RequestMapping(value="/products/",method=RequestMethod.GET)
	public @ApiResponse(description="Product Object") List<Product> getProducts(){
		return (List<Product>) repo.findAll();		
	}
	
//	localhost:8080/products/products/9 
	@Operation(summary="Return a product based on id",description="Takes Id return single product")
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public @ApiResponse(description="Product Object") Product getProduct(@Parameter(description="Id of the Product")@PathVariable("id") Integer id) {
		return repo.findById(id).get();
	}
	
	
//	insert,update you need pass data form postman request body->row->json
	//localhost:8080/products/ -> insert url use in postman
	@Operation(summary="Create the product",description="Create the product")
	@RequestMapping(value="/products/",method=RequestMethod.POST)
	public Product create1(@Valid @RequestBody Product product) {
		return repo.save(product);
	}
	
	//localhost:8080/products/ -> update url use in postman
	@Operation(summary="Update all column in product based on id",description="Update the product")
	@RequestMapping(value="/products/",method=RequestMethod.PUT)
	public Product update(@RequestBody Product product) {
		return repo.save(product);
	}
	
	//localhost:8080/products/ -> update url use in postman
	@Operation(summary="Update the product",description="Update the product")
	@RequestMapping(value="/products/",method=RequestMethod.PATCH)
	public Product update1(@RequestBody Product product) {
		return repo.save(product);
	}
	
	
	//localhost:8080/products/products/9   -> delete url use in postman
	@Operation(summary="Delete the product",description="Delete the product")
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
