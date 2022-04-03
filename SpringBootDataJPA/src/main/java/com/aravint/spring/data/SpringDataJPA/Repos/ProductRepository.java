package com.aravint.spring.data.SpringDataJPA.Repos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aravint.spring.data.SpringDataJPA.entities.Product;

@Component
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
