package com.spring.boot.security.product.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.product.Model.Role;


public interface RoleRepo extends JpaRepository<Role, Long> {

}
