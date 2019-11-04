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
/**
 * 
 * @author Asif
 *
 */

@Service
public class VehicleDetailsService {

	/**
	 * injecting vehicleDetailsRepository
	 */
	@Autowired
	private VehicleDetailsRepository vehicleDetailsRepository;
	
	/**
	 *  this class is responsible to retrieve vehicleDetail according to vehicle id
	 * @param vdId
	 * @return VehicleDetails
	 */
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
 
	/**
	 * this method will save vehicleDetails to database
	 * @param vehicleDetails
	 * @return VehicleDetails
	 */
	
	public VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails)
	{
	    return 	vehicleDetailsRepository.save(vehicleDetails);
	}
	
}
