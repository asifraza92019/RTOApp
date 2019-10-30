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

	@Autowired
	private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	
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
	
	
	
	public VehicleOwnerAddress saveVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress)
	{
		    return vehicleOwnerAddressRepository.save(vehicleOwnerAddress);
	}
	
	
	
}
