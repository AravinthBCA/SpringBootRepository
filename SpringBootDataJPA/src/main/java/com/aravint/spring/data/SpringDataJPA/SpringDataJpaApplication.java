package com.aravint.spring.data.SpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aravint.spring.data.SpringDataJPA.Repos.ProductRepository;
import com.aravint.spring.data.SpringDataJPA.entities.Product;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		ProductRepository obj= context.getBean(ProductRepository.class);
		System.out.println("-------------------------------------");
		Product product = new Product();
		product.setId(6);
		product.setName("Iphone");
		product.setDescription("Good");
		product.setPrice(1000D);
		obj.save(product);
	}

}
