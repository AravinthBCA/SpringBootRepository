package com.aravinth.spring.boot.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aravinth.spring.boot.SpringBoot.Dao.Dao;

@Component
public class Service {

	Dao dao;
	
	@Autowired
	Service(Dao dao){
		System.out.println("Service bean Created...");
		this.dao = dao;
	}
	
	public void save() {
		dao.create();
	}
	
}
