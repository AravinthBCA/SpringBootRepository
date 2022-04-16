package com.aravinth.springboot.basics.SpringBootBasics.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravinth.springboot.basics.SpringBootBasics.DAO.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO dao;

	public PaymentDAO getDao() {
		return dao;
	}

	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
	
}
