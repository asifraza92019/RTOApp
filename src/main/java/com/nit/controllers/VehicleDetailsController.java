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
import com.nit.services.VehicleDetailsService;
import com.nit.services.VehicleOwnerAddressService;
import com.nit.services.VehicleOwnerDetailsService;

/**
 * this controller will handle al incoming request related to vehicle_details
 * @author Asif
 *
 */

@Controller
@RequestMapping("/vehicledetails")
public class VehicleDetailsController {

	      @Autowired
	  private VehicleDetailsService vehicleDetailsService;
	
	      @Autowired
	 private VehicleOwnerAddressService vehicleOwnerAddressService;
	      
	       @Autowired
	 private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	       
	 private static Logger logger = LogManager.getLogger(VehicleDetailsController.class);
	      
          /**
           * this method will load vehicle details from 
           * @param model
           * @param request
           * @exception NullPointerException
           * @See  VehicleExceptionHandler
           * @return vehicle_details
           * 
           */
	       
	       
	       @RequestMapping(value="/loadvehicledetails", method=RequestMethod.GET)
	     public String loadVehicleDetailsForm( Model model, HttpServletRequest request)
	     {
	    	    
	    	  VehicleDetails vehicleDetails=null;
	    	  String  vehicleId = request.getParameter("vehicleId");
	    	  String  vehicleOwnerId = request.getParameter("vehicleOwnerId");
	    	  
	    	  logger.info("----start of loading vehicle details form -----------------");
	    	  
	    	  
	    	  if(vehicleId!=null && vehicleOwnerId !=null && !vehicleId.equals("") && !vehicleOwnerId.equals(""))
	    	  {
	    		   vehicleDetails= 
	    				  vehicleDetailsService.getVehicleDetailsById(Integer.parseInt(vehicleId));
	    		   model.addAttribute("vehicleDetails",vehicleDetails);
	    		   model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
	    		   return AppConstant.VEHICLE_DETAILS;
	    	  }
	    	  
	    vehicleDetails= new VehicleDetails();
	    model.addAttribute("vehicleDetails",vehicleDetails);
   		model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
   		
   		logger.info("-----end of vehicle details form ");
   		return AppConstant.VEHICLE_DETAILS;
	    	
	     }
	       
	      

	          /**
	           * this method will store the data into db and redirect to vehicle_summary page
	           * @param model
	           * @param request
	           * @exception NullPointerException
	           * @See  VehicleExceptionHandler
	           * @return vehicle_summary
	           * 
	           */
		      
	       @RequestMapping(value ="/handlevehicledetails", method = RequestMethod.POST)
	       public String handleNextBtn(@ModelAttribute("vehicleDetails") VehicleDetails vehicleDetails,
	    		   HttpServletRequest request, RedirectAttributes redirectAttributes,Model model
	    		   )
	       {
	    	    String vchDtlId= request.getParameter("vehicleId");
	    	    String vchlOwnrDtlId= request.getParameter("vehicleOwnerId");
	    	    String vehicleAddrId= request.getParameter("vehicleAddrId");
	    	    
	    	    logger.info("----- store the data into database and redirect to vehicle_summary page---------"); 
	    	    if(vchDtlId!=null && vchlOwnrDtlId !=null && !vchDtlId.equals("") && !vchlOwnrDtlId.equals("") && vehicleAddrId!=null && !vehicleAddrId.equals("") )
	    	    {
	    	    	vehicleDetails.setVehicleId(Integer.parseInt(vchDtlId));
	    	    	vehicleDetails.setVehicleOwnerDetails(vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vchlOwnrDtlId)));
	    	    VehicleDetails vchlDtl	=vehicleDetailsService.saveVehicleDetails(vehicleDetails);
	    	    	redirectAttributes.addAttribute("vehicleDetails",vchlDtl);
	    	    	redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID,vchlOwnrDtlId );
	    	    	redirectAttributes.addAttribute("vehicleId", vchDtlId);
	    	   VehicleOwnerAddress vhclOwnrAddr=
	    			   vehicleOwnerAddressService.getVehicleOwnerAddressById(Integer.parseInt(vehicleAddrId));
	    	   model.addAttribute("vehicleOwnerAddress",vhclOwnrAddr);
	    	    	
	    	    	return AppConstant.REDIRECT_VEHICLE_SUMMARY;
	    	    	
	    	    }
	    	    
	    	    vehicleDetails.setVehicleOwnerDetails(vehicleOwnerDetailsService.getVehicleOwnerDetailsById(Integer.parseInt(vchlOwnrDtlId)));
	    	    VehicleDetails vchlDtl	=vehicleDetailsService.saveVehicleDetails(vehicleDetails);
    	    	redirectAttributes.addAttribute("vehicleDetails",vchlDtl);
    	    	redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID,vchlOwnrDtlId );
    	    	redirectAttributes.addAttribute("vehicleId",vchlDtl.getVehicleId());
    	    	return AppConstant.REDIRECT_VEHICLE_SUMMARY;
	    	   
	       }
	       
	       

	          /**
	           * this method will load previous page
	           * @param model
	           * @param request
	           * @exception NullPointerException
	           * @See  VehicleExceptionHandler
	           * @return vehicle_owner_address
	           * 
	           */
		      
	   @RequestMapping(value ="/handlepreviousaddress", method= RequestMethod.GET)            
		     public String handlePreviousBtn(
		    		  @RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
		    		  
		    		  @RequestParam("vehicleAddrId") Integer vehicleAddrId,
		    		 Model model, RedirectAttributes redirectAttribute )
		     {
		                
		           logger.info("-----------------redirecting to vehicle_details-------");
		   
		    	      redirectAttribute.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		    	      
		    	        
		    	      VehicleOwnerAddress vhclOwnrAddr = vehicleOwnerAddressService.getVehicleOwnerAddressById(vehicleAddrId);
		    	      
		    	      model.addAttribute("vehicleOwnerAddress", vhclOwnrAddr);
		    	      
		    	       return AppConstant.REDIRECT_VEHICLE_OWNER_ADDRESS;
		     }
		     
	
}
