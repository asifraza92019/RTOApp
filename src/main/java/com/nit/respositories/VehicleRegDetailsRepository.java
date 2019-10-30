package com.nit.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleRegDetails;

/**
 * 
 * @author Asif
 * this inteface as a repository 
 */
@Repository
public interface VehicleRegDetailsRepository  extends JpaRepository<VehicleRegDetails, Integer>{

}
