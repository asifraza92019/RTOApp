package com.nit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.model.VehicleSummary;
import com.nit.respositories.VehicleDetailsRepository;
import com.nit.respositories.VehicleOwnerAddressRepository;
import com.nit.respositories.VehicleOwnerDetailsRepository;

/**
 * 
 * @author Asif
 * this class is reposible to fetch the data from all repository
 */


@Service
public class VehicleSummaryService {

	  /**
	   * @inject vehicleOwnerDetailsRepository
	   */
	
	  @Autowired
      private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;  
	  
	  /**
	   * @inject vehicleOwnerAddressRepository
	   */
	  @Autowired
	  private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	  
	  /**
	   * @inject vehicleDetailsRepository
	   */
	   @Autowired
	   private VehicleDetailsRepository vehicleDetailsRepository;
	
	   /**
	    * this method will return vehicle summary object according to vehicle OwnerId
	    * @param ownerId
	    * @return VehicleSummary
	    */
	   public VehicleSummary getVehicleSummayObjectById(Integer ownerId)
	   {
		   
		   VehicleSummary vehicleSummary = new VehicleSummary();
		   
		  Optional<VehicleOwnerDetails> optional1=
				   vehicleOwnerDetailsRepository.findById(ownerId);
		  
		  Optional<VehicleOwnerAddress> optional2= 
				  vehicleOwnerAddressRepository.findById(ownerId);
		  
		  Optional<VehicleDetails> optional3 = 
				   vehicleDetailsRepository.findById(ownerId);
		  
		  if(optional1.isPresent())
		  {
			  vehicleSummary.setVehicleOwnerDetails(optional1.get());
		  }
		  
		  if(optional2.isPresent())
		  {
			  vehicleSummary.setVehicleOwnerAddress(optional2.get());
		  }
		  
		  if(optional3.isPresent())
		  {
			  vehicleSummary.setVehicleDetails(optional3.get());
		  }
		  
		  
		  return vehicleSummary;
	   }
	     
	
	
}
