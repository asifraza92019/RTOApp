package com.nit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerDetails;
import com.nit.services.VehicleDetailsService;
import com.nit.services.VehicleOwnerDetailsService;
/**
 * 
 * @author Asif
 * this controller will handle all incomming request 
 *  related to Vehicle Details
 */

@Controller
@RequestMapping("/vehicledetail")
public class VehicleDetailsController {

	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	
	 @Autowired
	private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	
	     @RequestMapping(value= "/loadvehicledetails", method = RequestMethod.GET)
	   public String loadVehicleDetailsForm(@RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
			   Model model)
	   {
	    	 VehicleDetails   vehicleDetails = new VehicleDetails();
	    	 model.addAttribute("vehicleDetails", vehicleDetails);
	    	 model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		     return AppConstant.VEHICLE_DETAILS;
	   }
	     
	     
	     
	     @RequestMapping(value="/handlevehicledetails" , method=RequestMethod.POST)
	     public String handleNextBtn(@RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
	    		 Model model, @ModelAttribute("vehicleDetails") VehicleDetails vehicleDetails, 
	    		 RedirectAttributes redirectAttributes
	    		 )
	     {
	    	 
	    	     System.out.println(vehicleOwnerId);
	    	       
	    	 VehicleOwnerDetails vhclOwnrDtls = vehicleOwnerDetailsService.getVehicleOwnerDetailsById(vehicleOwnerId);
	    	 vehicleDetails.setVehicleOwnerDetails(vhclOwnrDtls);
	    	 
	    	 VehicleDetails vhclDtls= 
	    			 vehicleDetailsService.saveVehicleDetails(vehicleDetails);
	    	 System.out.println(vhclDtls);
	    	 
	    	 redirectAttributes.addFlashAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
	    	 
	    	 return AppConstant.REDIRECT_VEHICLE_SUMMARY;
	     }
	
	     
	     
	     @RequestMapping(value ="/handlepreviousaddress" , method= RequestMethod.GET)
	     public String handlePreviousBtn(@RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
	    		 Model model, RedirectAttributes redirectAttributes)
	     {
	    	         redirectAttributes.addFlashAttribute(AppConstant.VEHICLE_OWNER_ID,vehicleOwnerId);
	    	         
	                  return AppConstant.REDIRECT_VEHICLE_OWNER_ADDRESS;	 
	     }
	     
	     
}
