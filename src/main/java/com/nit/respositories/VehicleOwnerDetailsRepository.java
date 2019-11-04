package com.nit.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleOwnerDetails;
import java.lang.Integer;
import java.util.List;

/**
 * 
 * @author Asif
 *   this interface act as vehicle owner details repository
 */


@Repository
public interface VehicleOwnerDetailsRepository  extends JpaRepository<VehicleOwnerDetails, Integer> {
      
	   VehicleOwnerDetails findByVehicleOwnerId(Integer vehicleownerid);
}
