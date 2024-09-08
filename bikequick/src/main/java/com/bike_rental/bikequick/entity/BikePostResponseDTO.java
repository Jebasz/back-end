package com.bike_rental.bikequick.entity;

import java.time.LocalDateTime;

public class BikePostResponseDTO {
	
	    private Long id;
	    private String name;
	    private String type;
	    private LocalDateTime createdAt;
	    
	    
		public BikePostResponseDTO(Long id, String name, String type, LocalDateTime createdAt) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
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


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public LocalDateTime getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

	

	  
	}