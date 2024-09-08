package com.bike_rental.bikequick.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bike_rental.bikequick.entity.Bike;
import com.bike_rental.bikequick.entity.BikeListingDTO;
import com.bike_rental.bikequick.entity.BikePostResponseDTO;
import com.bike_rental.bikequick.error_handling.ErrorResponse;
import com.bike_rental.bikequick.repository.BikeRepository;
import com.bike_rental.bikequick.service.BikeQuickService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bike-quick")
public class BikeQuickController {

	BikeRepository bikeRepo;

	@Autowired
	private BikeQuickService bqService;

	public BikeQuickController(BikeRepository bikeRepo) {
		this.bikeRepo = bikeRepo;
	}

	// Get all available bikes
	@GetMapping("/bikes")
	public List<Bike> bikeList() {
		return bikeRepo.findAll();

	}

	// Add a new Bike
	@PostMapping("/bikes")
	public ResponseEntity<BikePostResponseDTO> newBikeListing(@Valid @RequestBody BikeListingDTO newBikeValues) {
		BikePostResponseDTO response = bqService.createBike(newBikeValues);
		
		// Return 201 Created status with Location header pointing to the newly created user resource
        URI location = ServletUriComponentsBuilder
                          .fromCurrentRequest()
                          .path("/{id}")
                          .buildAndExpand(response.getId())
                          .toUri();
        
        return ResponseEntity.created(location).body(response);

	}

	// Update bike information
	@PutMapping("/bikes/{id}")
	public ResponseEntity<?> bikeDetailsUpdate(@PathVariable("id") Long id, @RequestBody BikeListingDTO bikeUpdatedValues) {
		BikePostResponseDTO response = bqService.updateBike(id, bikeUpdatedValues);
		
		if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Resource not found", "Bike with ID " + id + " not found"));
        }

	}

	// Get bike details by ID
	@GetMapping("/bikes/{id}")
	public ResponseEntity<?> bikeDetailsUpdate(@PathVariable("id") Long id) {
		Bike bike  = bikeRepo.findById(id).orElse(null);
		
		if(bike == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Resource not found", "Bike with ID " + id + " not found"));
		}
		
		return ResponseEntity.ok(bike);

	}
	
	
	// Delete bike from listing
	@DeleteMapping("/bikes/{id}")
	public ResponseEntity<?> deleteBike(@PathVariable("id") Long id) {
        if (bikeRepo.existsById(id)) {
            bikeRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Resource not found", "Bike with ID " + id + " not found"));
        }
    }

}