package com.spring.boot.reactive.mongo.SpringBootReactiveMongo.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Products {
	
	@Id
	private String id;
	private String name;
	private String description;
//	private Double price;
	
	public Products(String id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
//		this.price = price;
	}

	public Products() {
		System.out.println("Constructor called....");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + "]";
	}	
}
