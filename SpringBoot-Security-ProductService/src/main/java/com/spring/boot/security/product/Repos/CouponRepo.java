package com.spring.boot.security.product.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.product.Model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
	Coupon findByCode(String code);
}
