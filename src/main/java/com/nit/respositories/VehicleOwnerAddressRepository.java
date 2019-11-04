package com.nit.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleOwnerAddress;

/**
 * 
 * @author Asif
 * this interface act as vehicle owner address repository
 */

@Repository
public interface VehicleOwnerAddressRepository extends JpaRepository<VehicleOwnerAddress,Integer>  {

	 
	@Query("select d from VehicleOwnerAddress d where  d.vehicleOwnerDetails.vehicleOwnerId=:id")
	public Optional<VehicleOwnerAddress> findByOwnerId(Integer id);
	 
	
}
