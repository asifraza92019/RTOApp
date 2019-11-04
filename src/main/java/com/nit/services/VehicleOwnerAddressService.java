package com.nit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.VehicleOwnerAddress;
import com.nit.respositories.VehicleOwnerAddressRepository;

/**
 * 
 * @author Asif
 * This class is responsible to communicate with vehicle owner address repository
 */

@Service
public class VehicleOwnerAddressService {

	/**
	 * injecting vehicleOwnerAddressRepository
	 *  @inject vehicleOwnerAddressRepository
	 */
	
      @Autowired
	private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	
      /**
       * this method will retrieve the data from db according to vehicelOwnerId
       * @param vownerAddId
       * @return VehicleOwnerAddress
       */
	public VehicleOwnerAddress getVehicleOwnerAddressById(Integer vownerAddId)
	{
		  Optional<VehicleOwnerAddress>  optional = 
				         vehicleOwnerAddressRepository.findById(vownerAddId);
		  if(optional.isPresent())
		  {
			  return optional.get();
		  }
		  
		  return new VehicleOwnerAddress();
	}
	
	/**
	 *  this method is responsible to save the data into db 
	 * @param vehicleOwnerAddress
	 * @return VehicleOwnerAddress
	 */
	
	public VehicleOwnerAddress saveVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress)
	{
		    return vehicleOwnerAddressRepository.save(vehicleOwnerAddress);
	}
	
	
	
}
