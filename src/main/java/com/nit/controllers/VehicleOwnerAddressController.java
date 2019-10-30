package com.nit.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.services.VehicleOwnerAddressService;
import com.nit.services.VehicleOwnerDetailsService;

/**
 * 
 * @author Asif
 * this controller is responsible to handle all request related to vehicle owner details
 */

@Controller
@RequestMapping("/address")
public class VehicleOwnerAddressController {

	         @Autowired
	     private VehicleOwnerAddressService vehicleOwnerAddressService;
	         
	          @Autowired
	         private VehicleOwnerDetailsService VehicleOwnerDetailsService;
	
	   @RequestMapping(value="/vehicleowneraddress" , 
			   method = RequestMethod.GET)
	 public String loadVehicleOwnerAddressForm(Model model,
			 HttpServletRequest request,  @RequestParam("ownerId") Integer ownerId)
	 {
		 
		    
		   VehicleOwnerAddress vehicleOwnerAddress = new VehicleOwnerAddress();
		   
		   model.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
		   model.addAttribute(AppConstant.VEHICLE_OWNER_ID, ownerId);
		   return AppConstant.VEHICLE_OWNER_ADDRESS;
		   
	 }
	   
	     @RequestMapping(value="/saveowneraddress", method = RequestMethod.POST)
	   public String handleNextBtn(Model model, @ModelAttribute("vehicleOwnerAddress") VehicleOwnerAddress vehicleOwnerAddress,
			   RedirectAttributes redirectAttributes, @RequestParam("ownerId")Integer ownerId)
	   {
		   
	    	 VehicleOwnerDetails vehicleOwnerDetails 
	    	 = VehicleOwnerDetailsService.getVehicleOwnerDetailsById(ownerId);
	    	 
	    	 vehicleOwnerAddress.setVehicleOwnerDetails(vehicleOwnerDetails);
	    	 
	    VehicleOwnerAddress vhclOwnrAddr=	
	    vehicleOwnerAddressService.saveVehicleOwnerAddress(vehicleOwnerAddress);
	    	 
	           System.out.println(vhclOwnrAddr);
	           model.addAttribute(AppConstant.VEHICLE_OWNER_ID, ownerId);
	    
	    	return  AppConstant.REDIRECT_VEHICLE_DETAIL;      
	    	
	   }
	   
	     @RequestMapping(value="/handlevehicleowner", method = RequestMethod.GET)
	     public String handlePreviousBtn(@RequestParam("ownerId") Integer vehicleOwnerId, 
	    		 Model model, RedirectAttributes redirectAttribute )
	     {
	    	 
	    	     redirectAttribute.addFlashAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
	    	   return AppConstant.REDIRECT_VEHICLE_OWNER_DETAILS;
	     }
	     
	
	   
}
 