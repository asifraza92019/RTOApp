package com.nit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Asif
 *  this class is reposible to communicate with Vehicle details repository
 */

import com.nit.model.VehicleDetails;
import com.nit.respositories.VehicleDetailsRepository;

@Service
public class VehicleDetailsService {

	@Autowired
	private VehicleDetailsRepository vehicleDetailsRepository;
	
	public VehicleDetails getVehicleDetailsById(Integer  vdId)
	{
		      Optional<VehicleDetails> optional=
		    		   vehicleDetailsRepository.findById(vdId);
		      if(optional.isPresent())
		      {
		    	  return optional.get();
		      }
		      return new VehicleDetails();
 	}
 
	
	public VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails)
	{
	    return 	vehicleDetailsRepository.save(vehicleDetails);
	}
	
}
