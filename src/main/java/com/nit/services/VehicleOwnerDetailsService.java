package com.nit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Asif
 * this class is responsible to communicate with Vehicle owner details repository
 */

import com.nit.model.VehicleOwnerDetails;
import com.nit.respositories.VehicleOwnerDetailsRepository;

/**
 * 
 * @author Asif
 * 
 */
@Service
public class VehicleOwnerDetailsService {

	 /**
	  * injecting vehicle owner detail repository
	  * @inject vehicleOwnerDetailsRepository
	  */
	         @Autowired
	       private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	
	         /**
	          * this method will retrieve data from db according to ownerId
	          * @param ownerId
	          * @return VehicleOwnerDetails
	          */
	
     public VehicleOwnerDetails  getVehicleOwnerDetailsById(Integer ownerId)
     {
       Optional<VehicleOwnerDetails> optional=
    		    vehicleOwnerDetailsRepository.findById(ownerId);
        
          if(optional.isPresent())
          {
        	  return  optional.get();
          }
       
          return new VehicleOwnerDetails();
    	 
     }
	         
     /**
      * this method is responsible to saveVehicleOwnerDetails data into database
      * @param vehicleOwnerDetails
      * @return
      */

     public  VehicleOwnerDetails  saveVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails)
     {
    	 
    	 return   vehicleOwnerDetailsRepository.save(vehicleOwnerDetails);
     }
     
     
     
}
