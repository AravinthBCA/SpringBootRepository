package com.spring.boot.security.SpringBootSecurityCouponService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.security.SpringBootSecurityCouponService.Model.Coupon;
import com.spring.boot.security.SpringBootSecurityCouponService.Repos.CouponRepo;

@Controller
public class CouponController {

	@Autowired
	private CouponRepo repo;
	
	@GetMapping("/createCoupon")
	public String createCoupon() {
		return "createCoupon";
	}
	
	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		repo.save(coupon);
		return "createResponse";
	}
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView mav = new ModelAndView("couponDetails");
		mav.addObject(repo.findByCode(code));
		return mav;
	}
	
}
