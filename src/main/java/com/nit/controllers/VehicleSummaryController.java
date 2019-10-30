package com.nit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.app.constant.AppConstant;

/**
 * 
 * @author Asif
 * This controller is responsibe to handle all request related to vehicle summary 
 * this controller will communicated with all all repository to get data from all the 
 * table
 */

@Controller
@RequestMapping("/summary")
public class VehicleSummaryController {

	
	 @RequestMapping(value ="/handlesummary" , method= RequestMethod.GET)
	public String handleVehicleSummary(@RequestParam("vehicleOwnerId")Integer vehicleOwnerId,
			Model model)
	{
		
		 model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		return AppConstant.VEHICLE_SUMMARY;
	}
	
	 
	 @RequestMapping(value="/handlesummaryregbtn", method=RequestMethod.GET)
	public String handleRegistrationBtn(Model model, RedirectAttributes redirectAttributes,
			@RequestParam("vehicleOwnerId") Integer vehicleOwnerId)
	{
	       
		 redirectAttributes.addFlashAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		 
		 
		 return AppConstant.REDIRECT_VEHICLE_REGISTRATION_DETAILS;
	}
	
}
