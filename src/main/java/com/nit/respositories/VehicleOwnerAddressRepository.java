package com.nit.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleOwnerAddress;

/**
 * 
 * @author Asif
 * this interface act as vehicle owner address repository
 */

@Repository
public interface VehicleOwnerAddressRepository extends JpaRepository<VehicleOwnerAddress,Integer>  {

}
