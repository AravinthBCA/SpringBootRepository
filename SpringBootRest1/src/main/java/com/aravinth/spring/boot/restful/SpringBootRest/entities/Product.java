package com.aravinth.spring.boot.restful.SpringBootRest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="product")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="ID")
	private Integer id;
	
	@Column(name="BRAND")
	private String brand;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;
	
}
