package com.aravinth.spring.boot.restful.SpringBootRest.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

public interface ProductRepo extends CrudRepository<Product,Integer> {

}
