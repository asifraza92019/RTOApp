package com.nit.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 *  this controller will handle all request related to vehicle owner details
 */



@Controller
@RequestMapping("/vehicle")
public class VehicleOwnerDetailsController {

	   @Autowired
	private VehicleOwnerDetailsService vehicleOwnerDetailsService;

	   
	              
	 private static Logger logger= 
			 LogManager.getLogger(VehicleOwnerDetailsController.class);

	 
	 /**
	  * 
	  * @param model
	  * @param request
	  * @return vehicle_owner_details
	  */
	 
	 
	   @RequestMapping(value="/index" , method = RequestMethod.GET)
	  public String loadForm(Model model, HttpServletRequest request)
	  {
		   logger.info("------------loading of onwner registration started--------------");
		   
		   VehicleOwnerDetails vehicleOwnerDetails=null;
		   
		  String vhclOwnrId = request.getParameter("vehicleOwnerId");
		  if(vhclOwnrId!=null && !vhclOwnrId.equals(""))
		  {
              vehicleOwnerDetails=    
			  vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vhclOwnrId));
             model.addAttribute(AppConstant.VEHICLE_OWNER_ID,vhclOwnrId );
             model.addAttribute("vehicleOwnerDetails", vehicleOwnerDetails);
              
		  }
		  else
		  {
			  vehicleOwnerDetails= new VehicleOwnerDetails();
		  }
		  model.addAttribute("vehicleOwnerDetails", vehicleOwnerDetails);
		 
		  logger.info("------------loadding of owner detail form end -------------");
		  return AppConstant.VEHICLE_OWNER_DETAILS;
		  
		   
	  }
	  	  
	   /**
	    * 
	    * @param model
	    * @param vehicleOwnerDetails
	    * @param request
	    * @param redirectAttributes
	    * @return redirect to vehicle_owner_address_details
	    */
	   
	   
	  @RequestMapping(value="/savevehicleownerdetails", method= RequestMethod.POST)
	 public String handleNextBtn(Model model,
		@ModelAttribute("vehicleOwnerDetails") VehicleOwnerDetails vehicleOwnerDetails,
		HttpServletRequest request, RedirectAttributes redirectAttributes)
	   {
		  
		
		   String vehicleOwnerId= request.getParameter("vehicleOwnerId");
		  // Integer vhcleOwnrId = Integer.parseInt(vehicleOwnerId);
		   
		   logger.info("-----inserting the owner data into database according to owner Id: " + vehicleOwnerId + "--------");
		   
		   if(vehicleOwnerId!=null & !vehicleOwnerId.equals(""))
		   {
			   vehicleOwnerDetails.setVehicleOwnerId(Integer.parseInt(vehicleOwnerId));
			   
			   VehicleOwnerDetails vhclOwnrDtls=
				vehicleOwnerDetailsService.saveVehicleOwnerDetails(vehicleOwnerDetails);
			   redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID, vhclOwnrDtls.getVehicleOwnerId());
			   return AppConstant.REDIRECT_VEHICLE_OWNER_ADDRESS; 
			   
		   }
		   
		   
		   vehicleOwnerDetails=
		   vehicleOwnerDetailsService.saveVehicleOwnerDetails(vehicleOwnerDetails);
		  
		 Integer   vhcleOwnrId =  vehicleOwnerDetails.getVehicleOwnerId();
		   
		   redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID, vhcleOwnrId);
		   
		   logger.info("----owner data inserted to database and redirect to address page -- ");
		   return AppConstant.REDIRECT_VEHICLE_OWNER_ADDRESS;
		   
		   
	   }
	
}
