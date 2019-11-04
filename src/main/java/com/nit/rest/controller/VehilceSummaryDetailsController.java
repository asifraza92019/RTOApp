package com.nit.rest.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.rest.entity.VehicleSummaryEntity;
import com.nit.rest.services.VehilceSummaryDetailsService;

@RestController
@RequestMapping("/vehicleapi")
public class VehilceSummaryDetailsController {

	 
	 @Autowired
	private VehilceSummaryDetailsService vehicleSummaryDetailsService;
	     
	    @RequestMapping(value="/api", method = RequestMethod.GET)
	  public VehicleSummaryEntity getData(@RequestParam("regNo") String regNo)
	  {
		  
      		return   vehicleSummaryDetailsService.getVehicleDetailsByRegNumber(regNo);
		   
	  }
}
