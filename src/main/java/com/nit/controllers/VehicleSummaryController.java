package com.nit.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nit.app.constant.AppConstant;
import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.model.VehicleRegDetails;
import com.nit.model.VehicleSummary;
import com.nit.services.VehicleOwnerDetailsService;
import com.nit.services.VehicleRegDetailsService;
import com.nit.services.VehicleSummaryService;

/**
 * this controller will handle all incoming request relate to vehicle_summary
 * @author Asif
 * 
 */

@RequestMapping("/summary")
@Controller
public class VehicleSummaryController {

	
	
	@Autowired
	private VehicleSummaryService  vehicleSummaryService;
	     
	
	@Autowired
    public JavaMailSender emailSender;

	
	 @Autowired
	  private VehicleRegDetailsService vehicleRegDetailsService;
	 
	  @Autowired
	 private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	  
	 private static Logger logger = LogManager.getLogger(VehicleSummaryController.class);
	  
	 /**
	  *  this will load vehicle_summary form 
	  * @param vehicleOwnerId
	  * @param vehcId
	  * @param vehicleId
	  * @param model
	  * @return vehcle_summary form 
	  */
	  
	  @RequestMapping(value ="/handlesummary" , method= RequestMethod.GET)
	public String handleVehicleSummary(@RequestParam("vehicleOwnerId")Integer vehicleOwnerId,
			@RequestParam("vehicleDetails") Integer vehcId ,@RequestParam("vehicleId") Integer vehicleId,
			Model model)
	{
		  logger.info("----start of collecting data from database -------------");
		  
		   VehicleSummary vehicleSummary = 
				   vehicleSummaryService.getVehicleSummayObjectById(vehicleOwnerId);
		
		   logger.info("---vehicle owner details data collected");
		   VehicleOwnerDetails vehicleOwnerDetails= 
				   vehicleSummary.getVehicleOwnerDetails();
		   
		   
		   logger.info("---- vehicle owner address data collected-------------");
		   VehicleOwnerAddress vehicleOwnerAddress =
				   vehicleSummary.getVehicleOwnerAddress();
		  
		   
		   logger.info("----- vehicle data collected --------------------------");
           VehicleDetails vehicleDetails= 
            		   vehicleSummary.getVehicleDetails();
               
           
           model.addAttribute("vehicleId", vehicleDetails.getVehicleId());
               
		   model.addAttribute("vehicleOwnerDetails", vehicleOwnerDetails);
		   model.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
		   model.addAttribute("vehicleDetails", vehicleDetails);
		
		   model.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
		   model.addAttribute("vehicleId", vehcId);
		   model.addAttribute("vehicleId", vehicleId);
		  
		   logger.info("----- end of all operation related to vehicle summary---------");
		return AppConstant.VEHICLE_SUMMARY;
	}

	
	  /**
	   * this method will handle next button request
	   * @param model
	   * @param redirectAttributes
	   * @param vehicleOwnerId
	   * @return vehicle_reg_details
	   */
		 @RequestMapping(value="/handlesummaryregbtn", method=RequestMethod.GET)
		public String handleRegistrationBtn(Model model, RedirectAttributes redirectAttributes,
				@RequestParam("vehicleOwnerId") Integer vehicleOwnerId)
		{
			 
			 logger.info("----- storing data into database and redirect to vehicle reg page--------");
		          
			 VehicleRegDetails vehicleRegDetails= new  VehicleRegDetails();
			 
			 VehicleOwnerDetails  vhclOwnrDtls=
					 vehicleOwnerDetailsService.getVehicleOwnerDetailsById(vehicleOwnerId); 
			    vehicleRegDetails.setVehicleOwnerDetails(vhclOwnrDtls);
			 
		VehicleRegDetails vhclRgDtls=
				 vehicleRegDetailsService.saveVehicleRegDetails(vehicleRegDetails);	    
		String vehicleRegNumber = vhclRgDtls.getVehicleRegNumber();	 
			 
		  redirectAttributes.addAttribute("vehicleRegNumber", vehicleRegNumber);
		  redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID,vehicleOwnerId);
		  
		  model.addAttribute("vehicleRegNumber", vehicleRegNumber);
		  model.addAttribute(AppConstant.VEHICLE_OWNER_ID,vehicleOwnerId); 
		   
		  //starting of email 
  
		  logger.info("------start of email operation -----------------");
		  
		   String email= vhclOwnrDtls.getEmail();
		   String lastName= vhclOwnrDtls.getLastName();
		  
		  SimpleMailMessage msg = new SimpleMailMessage();
		  msg.setFrom("asifraza4101995@gmail.com");
		  msg.setTo(email);
		  msg.setSubject("Vehicle Register Number"); 
		  msg.setText("Hi, Mr."+lastName + "Your Vehicle Register Number: "+ vehicleRegNumber );
		  
		  emailSender.send(msg);
		  
		  logger.info("----- end of email --------------------");
		  
		  
		    return AppConstant.VEHICLE_REGISTRATION_DETAILS;
		}

		 /**
		  *  this method will handle previous request 
		  * @param redirectAttributes
		  * @param model
		  * @param vehicleOwnerId
		  * @param vehicleId
		  * @return vehicle_details
		  */
		 
		 
		 @RequestMapping(value="/handlevehicledetails", method= RequestMethod.GET)
		public String handlePreviousBtn(
		RedirectAttributes redirectAttributes,Model model, @RequestParam("vehicleOwnerId") Integer vehicleOwnerId,
		 @RequestParam("vehicleId") Integer vehicleId)
		{
			 logger.info("------------------redirecting to vehicle_details page -----------");
			redirectAttributes.addAttribute("vehicleId", vehicleId);
			redirectAttributes.addAttribute(AppConstant.VEHICLE_OWNER_ID, vehicleOwnerId);
			return AppConstant.REDIRECT_VEHICLE_DETAILS;
		}
	  
}
