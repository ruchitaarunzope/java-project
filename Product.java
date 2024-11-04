package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
private String id;
private String name;
private int price;
public Product(String id, String name, int price) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
}
public Product() {
	super();
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
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
