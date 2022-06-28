package com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Entities.Products;

public interface ProductRepository extends ReactiveMongoRepository<Products,String> {

}
