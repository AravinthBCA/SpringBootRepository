package com.spring.boot.security.product.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.security.product.Model.Coupon;
import com.spring.boot.security.product.Model.Product;
import com.spring.boot.security.product.Repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${CouponService.url}")
	private String couponServiceURL;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@PostMapping("/getProduct")
	public Product getProduct(@PathVariable("name") String name,@PathVariable("code") String code){
		System.out.println("Name : "+name);
		System.out.println("Code : "+code);
		Coupon coupon = restTemplate.getForObject(couponServiceURL+code,Coupon.class);
		Product product = repo.findByName(name);
//		return product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return null;
	}
	
}
