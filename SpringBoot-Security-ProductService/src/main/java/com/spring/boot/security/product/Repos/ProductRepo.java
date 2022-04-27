package com.spring.boot.security.product.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.product.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	Product findByName(String name);
}
