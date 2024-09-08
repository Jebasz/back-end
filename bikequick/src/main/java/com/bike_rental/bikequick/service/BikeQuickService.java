package com.bike_rental.bikequick.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike_rental.bikequick.entity.Bike;
import com.bike_rental.bikequick.entity.BikeListingDTO;
import com.bike_rental.bikequick.entity.BikePostResponseDTO;
import com.bike_rental.bikequick.repository.BikeRepository;

import jakarta.transaction.Transactional;

@Service
public class BikeQuickService {
	

    @Autowired
    private BikeRepository bikeRepository;

    @Transactional
    public BikePostResponseDTO createBike(BikeListingDTO newBikeInputs) {
    	
        // Create a new Bike entity from the DTO
        Bike newBike = new Bike();
        newBike.setName(newBikeInputs.getUsername());
        newBike.setAvailable(true);
        newBike.setDescription(newBikeInputs.getDescription());
        
        Long id = bikeRepository.findMaxId()+1;
        
        newBike.setId(id);
        newBike.setPrice(newBikeInputs.getPrice());
        newBike.setType(newBikeInputs.getType());
        
        LocalDateTime now = LocalDateTime.now();
        newBike.setCreatedAt(now);
        newBike.setLocation(newBikeInputs.getLocation());
        
        // Save the new Bike in the database
        Bike savedBike = bikeRepository.save(newBike);
        
        // Convert entity to response DTO for New Bike
        return new BikePostResponseDTO(savedBike.getId(), savedBike.getName(), savedBike.getType(), savedBike.getCreatedAt());
    }

	public BikePostResponseDTO updateBike(Long id, BikeListingDTO bikeUpdatedValues) {

		 		Bike existingBike = bikeRepository.findById(id).orElse(null);
		 		Bike updatedBike = null;
		        // Update the bike's 
		 		if(existingBike!=null) {
		        existingBike.setName(bikeUpdatedValues.getUsername());
		        existingBike.setDescription(bikeUpdatedValues.getDescription());
		        existingBike.setType(bikeUpdatedValues.getType());
		        existingBike.setPrice(bikeUpdatedValues.getPrice());
		        existingBike.setLocation(bikeUpdatedValues.getLocation());

		        // Save the updated bike
		        updatedBike = bikeRepository.save(existingBike);
		 		}
		 		else {
		 			return null;
		 		}
		 		
		 		return new BikePostResponseDTO(updatedBike.getId(), updatedBike.getName(), updatedBike.getType(), updatedBike.getCreatedAt());

	}

}
