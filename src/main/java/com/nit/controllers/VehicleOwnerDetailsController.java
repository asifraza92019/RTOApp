package com.nit.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.AppenderControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleOwnerDetails;
import com.nit.services.VehicleOwnerDetailsService;

/**
 * 
 * @author Asif
 * this contrller is resposible to handle all request related to vehicle owner details
 */


@Controller
@RequestMapping("/vehicle")
public class VehicleOwnerDetailsController {

	  @Autowired
	private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	
	  
	   @RequestMapping(value="/index" , method = RequestMethod.GET)
	  public String loadForm(Model model, HttpServletRequest request)
	  {
		   VehicleOwnerDetails vehicleOwnerDetails=null;
		   
		  String vhclOwnrId = request.getParameter("vehicleOwnerId");
		  if(vhclOwnrId!=null && vhclOwnrId.equals(""))
		  {
              vehicleOwnerDetails=    
			  vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vhclOwnrId));
             model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerDetails);
              
		  }
		  else
		  {
			  vehicleOwnerDetails= new VehicleOwnerDetails();
		  }
		  model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerDetails);
		  return AppConstant.VEHICLE_OWNER_DETAILS;
		  
		   
	  }
	  	  
	   
	   
         @RequestMapping(value="/savevehicleowner", method= RequestMethod.POST)            	  
	   public String handleNextBtn(Model model,
			   @ModelAttribute("vehicleOwnerDetails") VehicleOwnerDetails vehicleOwnerDetails,
			    RedirectAttributes redirectAttributes)
	   {
		   
		   
		VehicleOwnerDetails vhclOwnrDtls=
		vehicleOwnerDetailsService.saveVehicleOwnerDetails(vehicleOwnerDetails);
		  
		Integer ownerId= vhclOwnrDtls.getVehicleOwnerId();
		//model.addAttribute("ownerId", ownerId);
		  redirectAttributes.addFlashAttribute(AppConstant.VEHICLE_OWNER_ID, ownerId);
	
	          return AppConstant.REDIRECT_VEHICLE_OWNER_ADDRESS;
		   
	   }
	   
	   
}
