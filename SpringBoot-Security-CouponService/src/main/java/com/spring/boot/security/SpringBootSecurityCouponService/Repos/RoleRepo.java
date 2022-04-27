package com.spring.boot.security.SpringBootSecurityCouponService.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.SpringBootSecurityCouponService.Model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
