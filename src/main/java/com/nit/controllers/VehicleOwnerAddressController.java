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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.services.VehicleOwnerAddressService;
import com.nit.services.VehicleOwnerDetailsService;

/**
 * 
 * @author Asif
 * This controller will handle all incomming request reqlated to vehicleOwnerAddress 
 */

@RequestMapping("/address")
@Controller
public class VehicleOwnerAddressController {

	 @Autowired
	private VehicleOwnerAddressService vehicleOwnerAddressService;
	 
	   @Autowired
	 private VehicleOwnerDetailsService vehicleOwnerDetailsService;

	  private static Logger logger = LogManager.getLogger(VehicleOwnerAddressController.class);
	   
	   
	   /**
	    *  this method is to display vehicle owner details
	    * @param model
	    * @param request
	    * @exception NullPointerException
	    * @See WebAppExceptionHandler
	    * @return vehicle_owner_address
	    */
	   
	   @RequestMapping(value="/addressform")
	public String loadVehicleOwnerAddressForm(Model model, HttpServletRequest request)
	{
		
		   VehicleOwnerAddress vehicleOwnerAddress=null;
		   
		   String vehicleOwnerId = request.getParameter("vehicleOwnerId");
		   String vehicleOnwerAdddrId= request.getParameter("addressId");
		   
		   logger.info("---- start of loading vehicle owner address form -------");
		   if(vehicleOnwerAdddrId!=null && !vehicleOnwerAdddrId.equals(""))
		   {
			   vehicleOwnerAddress=
				vehicleOwnerAddressService.getVehicleOwnerAddressById(Integer.parseInt(vehicleOnwerAdddrId));
			   
			    model.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
			    model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
			    Integer vhcladdrId= vehicleOwnerAddress.getAddressId();
			    model.addAttribute("addressId", vhcladdrId);
			    return AppConstant.VEHICLE_OWNER_ADDRESS;
		   }
		 vehicleOwnerAddress= new VehicleOwnerAddress();
		 model.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
		 model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		 
		 logger.info("---- end vehicle owner address form  ");
		 return AppConstant.VEHICLE_OWNER_ADDRESS;
		   
	}
	
	   
	   /**
	    *  this method is to store data into db and redirect to vehicle_details page
	    * @param model
	    * @param request
	    * @exception NullPointerException
	    * @See WebAppExceptionHandler
	    * @return vehicle_details
	    */
	   
	   @RequestMapping(value="/saveowneraddress", method = RequestMethod.POST)
	   public String handleNextBtn(@ModelAttribute("vehicleOwnerAddress") VehicleOwnerAddress vehicleOwnerAddress,
			   Model model , RedirectAttributes redirectAttributes , HttpServletRequest request)
	   {
		   
		   logger.info("----- storing data into db ---- ");
		   
		  String vhclOwnrId= request.getParameter("vehicleOwnerId");
		  String vhclOwnrAddrid = request.getParameter("vehicleAddrId");
		  if(vhclOwnrAddrid!=null && !vhclOwnrAddrid.equals(""))
		  {
			  vehicleOwnerAddress.setAddressId(Integer.parseInt(vhclOwnrAddrid));
		       
			  vehicleOwnerAddress.setVehicleOwnerDetails(vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vhclOwnrId)));
			  VehicleOwnerAddress vhclOwnrAddress=
			  vehicleOwnerAddressService.saveVehicleOwnerAddress(vehicleOwnerAddress);
			  model.addAttribute("vehicleOwnerAddress", vhclOwnrAddress);
			  redirectAttributes.addAttribute("vehicleAddrId", vhclOwnrId);
			  redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID, vhclOwnrId);
			  redirectAttributes.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
			  return AppConstant.REDIRECT_VEHICLE_DETAILS;
		  }
		   
		  vehicleOwnerAddress.setVehicleOwnerDetails(vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vhclOwnrId)));
		  VehicleOwnerAddress vhclOwnrAddr=
		  vehicleOwnerAddressService.saveVehicleOwnerAddress(vehicleOwnerAddress);
		  redirectAttributes.addAttribute("addressId", vhclOwnrAddr.getAddressId());
		  redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID, vhclOwnrId);
		  redirectAttributes.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
		  model.addAttribute("vehicleOwnerAddress", vhclOwnrAddr);
		  
		  logger.info("--- after inserting data into database redirecting to vehicle_detail page ------------");
		  
		  return AppConstant.REDIRECT_VEHICLE_DETAILS;
		  
	   }
	   
	   
	   
	   /**
	    *  this method will redirect you to previous page vehicle_owner_details
	    * @param model
	    * @param request
	    * @exception NullPointerException
	    * @See WebAppExceptionHandler
	    * @return  vehicle_owner_details
	    */
	   
	   @RequestMapping(value="/handlevehicleowner", method = RequestMethod.GET)
	     public String handlePreviousBtn(@RequestParam("vehicleOwnerId") Integer vehicleOwnerId, 
	    		 Model model, RedirectAttributes redirectAttribute )
	     {
		   
		   logger.info("-------redirecting to previous page vehicle_owner_details----------");
	    	      redirectAttribute.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
	    	      
	    	   return AppConstant.REDIRECT_VEHICLE_OWNER_DETAILS;
	     }
	     
	   
}
