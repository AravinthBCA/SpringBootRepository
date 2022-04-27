package com.spring.boot.security.SpringBootSecurityCouponService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.boot.security.SpringBootSecurityCouponService.Model.Coupon;
import com.spring.boot.security.SpringBootSecurityCouponService.Repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo repo;
	
	@PostMapping(value="/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping(value="/coupons/{code}") 
	public Coupon get(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
	
}
