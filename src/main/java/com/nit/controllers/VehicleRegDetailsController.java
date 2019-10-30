package com.nit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleOwnerDetails;
import com.nit.model.VehicleRegDetails;
import com.nit.services.VehicleOwnerDetailsService;
import com.nit.services.VehicleRegDetailsService;

/**
 * 
 * @author Asif
 * this controller is reponsible to handle all the request related to vehicle registation
 */

@Controller
@RequestMapping("/vehicleReg")
public class VehicleRegDetailsController {
   
	     @Autowired
	  private VehicleRegDetailsService vehicleRegDetailsService;
	     
	     @Autowired
	     private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	     
	    @RequestMapping(value= "/final", method= RequestMethod.GET)
	public String saveVehicleRegDtls(@RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
			Model model)
	{ 
	    	
	    	VehicleRegDetails vehicleRegDetails= new VehicleRegDetails();
	    	
	           VehicleOwnerDetails vhclOwnrDtls= 
	        		   vehicleOwnerDetailsService.getVehicleOwnerDetailsById(vehicleOwnerId);
	    	
	           vehicleRegDetails.setVehicleOwnerDetails(vhclOwnrDtls);
	    	VehicleRegDetails vhclRegDtls= 	
	    			
	    	vehicleRegDetailsService.saveVehicleRegDetails(vehicleRegDetails);
	    	
	     String regNumber    =	vhclRegDtls.getVehicleRegNumber();
	     model.addAttribute("regNumber", regNumber);
		  return AppConstant.VEHICLE_REGISTRATION_DETAILS;
	}
	
}
