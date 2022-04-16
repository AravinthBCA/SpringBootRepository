package com.aravinth.spring.boot.restful.SpringBootRest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

@SpringBootTest
class SpringBootRestApplicationTests {

	@Value("${productapi.services.url}")
	String baseUrl;
	
	
	@Test
	void testGetProduct() {
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product Product = restTemplate.getForObject(baseUrl+"/products/10",Product.class);
		System.out.println("-----------------------------------------------");
		System.out.println("Get Method : "+Product);
		System.out.println("-----------------------------------------------");
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product prod = new Product();
		prod.setId(10);
		prod.setName("Aravinth");
		prod.setDescription("Awesome");
		prod.setPrice(100D);
		Product Product = restTemplate.postForObject(baseUrl+"/",prod,Product.class);
		System.out.println("Create Method Product Name : "+prod.getName());
		System.out.println("-----------------------------------------------");
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product Prod = new Product(); 
		Prod.setId(10);
		Prod.setName("Aravinth");
		Prod.setDescription("Awesome");
		Prod.setPrice(500D);
		restTemplate.put(baseUrl+"/",Prod);
		System.out.println("-----------------------------------------------");
		System.out.println("Update Method Product Name : "+Prod.getName());
	}
	
	@Test
	void testDeleteProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product Product = restTemplate.getForObject(baseUrl+"/products/10",Product.class);
		restTemplate.delete(baseUrl+"/products/10");
		System.out.println("Delete Method : "+Product);
		System.out.println("-----------------------------------------------");
	}

}
