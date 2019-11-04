package com.nit.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleDetails;

/**
 * 
 * @author Asif
 * this inteface is a repository for Vehicle Details
 */

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Integer> {

	
	@Query("select d from VehicleDetails d where  d.vehicleOwnerDetails.vehicleOwnerId=:id")
	public Optional<VehicleDetails> findByOwnerId(Integer id);
	
}
