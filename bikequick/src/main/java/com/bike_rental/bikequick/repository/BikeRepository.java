package com.bike_rental.bikequick.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bike_rental.bikequick.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{
	
	@Query("SELECT MAX(b.id) FROM Bike b")
    Long findMaxId();

}
