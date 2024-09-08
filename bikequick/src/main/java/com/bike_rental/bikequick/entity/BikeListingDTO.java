package com.bike_rental.bikequick.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BikeListingDTO {
	
	    @NotBlank
	    private String username;

	    @NotBlank
	    private String description;

	    @NotBlank
	    private String type;

	    @Min(0)
	    private int price;
	    
	    @NotBlank
	    private String location;


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	    

	}

