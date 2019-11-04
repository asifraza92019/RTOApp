package com.nit.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.nit.app.constant.AppConstant;
import com.nit.rest.entity.VehicleSummaryEntity;
import com.nit.rest.services.VehilceSummaryDetailsService;
import com.nit.services.VehicleRegDetailsService;
import com.nit.services.VehicleSummaryService;

/**
 * 
 * @author Asif
 * this controller is reponsible to handle all the request related to vehicle registation
 */

@Controller
@RequestMapping("/vehicleReg")
public class VehicleRegDetailsController {

	/**
	 *  @Param vehicleSummaryService
	 *  
	 */
	
	   
	@Autowired
	private VehicleSummaryService vehicleSummaryService;
	
	/**
	 * @param vehicleRegDetailsService
	 */
	
	@Autowired
	private VehicleRegDetailsService vehicleRegDetailsService;
      	
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private VehilceSummaryDetailsService vehicleSummaryDetailsService;
	  
	/**
	 *  
	 * @return vehicle Reg details
	 */
	  @RequestMapping(value="/index", method = RequestMethod.GET)
	public String showMainPage()
	{
		return AppConstant.REDIRECT_VEHICLE_OWNER_DETAILS;
	}
	
	  
	 /**
	  *   Starting to generating pdf report to print 
	  */
	  
	  
	  @RequestMapping(value="/download", method= RequestMethod.GET)
	  public void createPdf(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam("regNumber") String regNumber)
	  {		  
		  
		  VehicleSummaryEntity vehicleSummaryEntity=
			vehicleSummaryDetailsService.getVehicleDetailsByRegNumber(regNumber); 
		  boolean isFlag= vehicleSummaryDetailsService.createPdf(vehicleSummaryEntity,context,request,response);
		  
		  if(isFlag)
		  {
			  String fullPath = request.getServletContext().getRealPath("resorces/reports/"+"details"+".pdf");
			  filedownload(fullPath,response,"details.pdf");
			  
		  }
		  
		  
	  }


	private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if(file.exists())
		{
			try
			{
				FileInputStream  fis= new FileInputStream(file);
				String mimeType= context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-disposition", "attachment;fileName="+fileName);

				OutputStream os= response.getOutputStream();
				byte[] buffer= new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while((bytesRead=fis.read(buffer))!=-1)
				{
					os.write(buffer, 0, bytesRead);
				}
				
				fis.close();
				os.close();
				file.delete();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	  
	  
	  
	
}
