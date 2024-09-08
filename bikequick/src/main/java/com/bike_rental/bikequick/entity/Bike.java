package com.bike_rental.bikequick.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bikes", schema = "bikerental")
public class Bike{
	
	@Id
	private Long id;
	private String name;
	private String description;
	private String type;
	@Column(name = "price_per_hour")
	private float price;
	@Column(name = "available")
	private boolean isAvailable;
	private String location;
	private LocalDateTime createdAt;
	
	
	//NoArgs Constructor
	public Bike() {
	
	}
	
	public Bike(Long id, String name, String description, String type, float price, boolean isAvailable, String location,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.isAvailable = isAvailable;
		this.location = location;
		this.createdAt = createdAt;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", price="
				+ price + ", isAvailable=" + isAvailable + ", location=" + location + ", createdAt=" + createdAt + "]";
	}
	
	
	
}