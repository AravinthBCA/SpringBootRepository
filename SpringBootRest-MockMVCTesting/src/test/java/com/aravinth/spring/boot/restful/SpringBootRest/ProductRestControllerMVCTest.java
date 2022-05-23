package com.aravinth.spring.boot.restful.SpringBootRest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aravinth.spring.boot.restful.SpringBootRest.Repositories.ProductRepo;
import com.aravinth.spring.boot.restful.SpringBootRest.entities.Product;

@WebMvcTest

class ProductRestControllerMVCTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductRepo repo;
	
	@Test
	void testFindAll() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDescription("Awesome");
		product.setPrice(1000D);
//		Iterable<Product> products = (Object)Arrays.asList(product);
//		when(repo.findAll()).thenReturn(products);
//		mockMvc.perform(get("products/").contextPath(null))
//		.andExpect(status().isOk());
	}
}
