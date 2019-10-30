package com.nit.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.VehicleDetails;

/**
 * 
 * @author Asif
 * this inteface is a repository for Vehicle Details
 */

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Integer> {

}
