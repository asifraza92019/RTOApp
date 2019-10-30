package com.nit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Asif
 *    This class is reponsible to get the from repository 
 *    related to vehicle registration 
 */

import com.nit.generator.RegistrationNumber;
import com.nit.model.VehicleRegDetails;
import com.nit.respositories.VehicleRegDetailsRepository;

@Service 
public class VehicleRegDetailsService {

	@Autowired
	private VehicleRegDetailsRepository vehicleRegDetailsRepository;
	
	
	public VehicleRegDetails getVehicleRegDetailsById(Integer vhclregId)
	{
		 Optional<VehicleRegDetails> optional = 
				       vehicleRegDetailsRepository.findById(vhclregId);
		 
		 if(optional.isPresent())
		 {
			 return optional.get();
		 }
	 
		  return  new VehicleRegDetails();
	}
	
	public VehicleRegDetails saveVehicleRegDetails(VehicleRegDetails vehicleRegDetails)
	{
	
		
		RegistrationNumber  regNoObject = new  RegistrationNumber();
		vehicleRegDetails.setRegCenter("California");
		vehicleRegDetails.setVehicleRegNumber(regNoObject.generateRegistrationNumber());
		
		   return vehicleRegDetailsRepository.save(vehicleRegDetails);
	}
	
	
}
