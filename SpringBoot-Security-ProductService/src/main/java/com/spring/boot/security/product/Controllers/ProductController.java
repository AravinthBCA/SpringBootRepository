package com.spring.boot.security.product.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.security.product.Model.Coupon;
import com.spring.boot.security.product.Model.Product;
import com.spring.boot.security.product.Repos.CouponRepo;
import com.spring.boot.security.product.Repos.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private CouponRepo couponRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${CouponService.url}")
	private String couponServiceURL;
	
	@GetMapping("/createProduct")
	public String createCoupon() {
		return "createProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveCoupon(Product product) {
		repo.save(product);
		return "createResponse";
	}
	
	@GetMapping("/showGetProduct")
	public String showGetProduct() {
		return "getProduct";
	}
	
	@PostMapping("/getProduct")
	public ModelAndView getProduct(String name,String code) {
//		System.out.println("Name : "+name);
//		ModelAndView mav = new ModelAndView("ProductDetails");
//		mav.addObject(repo.findByName(name));
//		return mav;
		System.out.println("Name : "+name);
		System.out.println("Code : "+code);
//		Coupon coupon = restTemplate.getForObject(couponServiceURL+code,Coupon.class);
		Coupon coupon = couponRepo.findByCode(code);
		ModelAndView mav = new ModelAndView("ProductDetails");
		Product product = repo.findByName(name);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		mav.addObject(product);
		return mav;
	}
	
}
