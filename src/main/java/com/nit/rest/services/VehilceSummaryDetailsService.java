package com.nit.rest.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.model.VehicleRegDetails;
import com.nit.respositories.VehicleDetailsRepository;
import com.nit.respositories.VehicleOwnerAddressRepository;
import com.nit.respositories.VehicleOwnerDetailsRepository;
import com.nit.respositories.VehicleRegDetailsRepository;
import com.nit.rest.entity.VehicleSummaryEntity;

@Service
public class VehilceSummaryDetailsService {
     
	   @Autowired
	  private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository; 
	   
	   @Autowired
	   private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	
	   @Autowired
	   private VehicleDetailsRepository vehicleDetailsRepository;
	   
	   @Autowired
	   private  VehicleRegDetailsRepository vehicleRegDetailsRepository;
	   
	   
	   public VehicleSummaryEntity getVehicleDetailsByRegNumber(String regNumber)
	   {
		   VehicleSummaryEntity vehicleSummaryEntity = new VehicleSummaryEntity();
		   
		   
		   VehicleRegDetails vehicleRegDetails= vehicleRegDetailsRepository.findByVehicleRegNumber(regNumber);
		   
		   vehicleSummaryEntity.setVehicleRegDetails(vehicleRegDetails);
		   Integer  vehicleOwnerId = vehicleRegDetails.getVehicleOwnerDetails().getVehicleOwnerId();
		   
		   VehicleOwnerDetails vehicleOwnerDetails = vehicleOwnerDetailsRepository.findByVehicleOwnerId(vehicleOwnerId);
		   vehicleSummaryEntity.setVehicleOwnerDetails(vehicleOwnerDetails);
		   
		   Optional<VehicleDetails> optional1= vehicleDetailsRepository.findByOwnerId(vehicleOwnerId);
		   
		   
		   Optional<VehicleOwnerAddress> optional = vehicleOwnerAddressRepository.findByOwnerId(vehicleOwnerId);
		   
		   if(optional.isPresent())
		   {
			   vehicleSummaryEntity.setVehicleOwnerAddress(optional.get());
		   }
		   
		   if(optional.isPresent())
		   {
			   vehicleSummaryEntity.setVehicleDetails(optional1.get());
		   }
		   
		   
		   return vehicleSummaryEntity;
		   
	   }


	public boolean createPdf(VehicleSummaryEntity vehicleSummaryEntity, ServletContext context,
			HttpServletRequest request, HttpServletResponse response) {
		
		Document document = new Document(PageSize.A4,15,15,45,30);
		try
		{
	       String filePath = context.getRealPath("/resources/reports");
	       File file = new File(filePath);
	       boolean exists = new File(filePath).exists();
	       if(!exists)
	       {
	    	   new File(filePath).mkdirs();
	    	   
	       }
	       
	       PdfWriter writer = PdfWriter.getInstance(document,
	    		   new FileOutputStream(file+"/"+"details"+".pdf"));
	       document.open();
	       Font mainFont = FontFactory.getFont("Arial",10,BaseColor.BLACK);
	       Paragraph paragraph = new Paragraph("Vehicle Details ", mainFont);
	       paragraph.setAlignment(Element.ALIGN_CENTER);
	       paragraph.setIndentationLeft(50);
	       paragraph.setIndentationRight(50);
	       paragraph.setSpacingAfter(10);
	       document.add(paragraph);
	       
	       PdfPTable table = new PdfPTable(1);
	       table.setWidthPercentage(100);
	       table.setSpacingBefore(10);
	       table.setSpacingAfter(10);
	       
	       Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
	       Font tableBody = FontFactory.getFont("Arial", 9,BaseColor.BLACK);
	       
	       float[] columnWidths = {4f};
	       table.setWidths(columnWidths);
	       
	       PdfPCell  vhclOwnrDtls= new PdfPCell(new Paragraph("VehicleOwnerDetails",tableHeader));
	       vhclOwnrDtls.setBorderColor(BaseColor.BLACK);
	       vhclOwnrDtls.setPaddingLeft(10);
	       vhclOwnrDtls.setHorizontalAlignment(Element.ALIGN_CENTER);
	       vhclOwnrDtls.setVerticalAlignment(Element.ALIGN_CENTER);
	       vhclOwnrDtls.setBackgroundColor(BaseColor.GRAY);
	       vhclOwnrDtls.setExtraParagraphSpace(5f);
	       table.addCell(vhclOwnrDtls);
	       
	       VehicleOwnerDetails vehicleOwnerDetails = vehicleSummaryEntity.getVehicleOwnerDetails();
	       
	       PdfPCell firstName= new PdfPCell(new Paragraph("FistName :"+vehicleOwnerDetails.getFirstName(),tableBody));
	       firstName.setBorderColor(BaseColor.BLACK);
	       firstName.setPaddingLeft(10);
	       firstName.setHorizontalAlignment(Element.ALIGN_LEFT);
	       firstName.setVerticalAlignment(Element.ALIGN_CENTER);
	       firstName.setBackgroundColor(BaseColor.WHITE);
	       firstName.setExtraParagraphSpace(5f);
	       table.addCell(firstName);
	       
	       
	       PdfPCell lastName= new PdfPCell(new Paragraph("LastName :"+vehicleOwnerDetails.getLastName(),tableBody));
	       lastName.setBorderColor(BaseColor.BLACK);
	       lastName.setPaddingLeft(10);
	       lastName.setHorizontalAlignment(Element.ALIGN_LEFT);
	       lastName.setVerticalAlignment(Element.ALIGN_CENTER);
	       lastName.setBackgroundColor(BaseColor.WHITE);
	       lastName.setExtraParagraphSpace(5f);
	       table.addCell(lastName);
	       
	       
	       PdfPCell gender= new PdfPCell(new Paragraph("Gender :"+vehicleOwnerDetails.getGender(),tableBody));
	       gender.setBorderColor(BaseColor.BLACK);
	       gender.setPaddingLeft(10);
	       gender.setHorizontalAlignment(Element.ALIGN_LEFT);
	       gender.setVerticalAlignment(Element.ALIGN_CENTER);
	       gender.setBackgroundColor(BaseColor.WHITE);
	       gender.setExtraParagraphSpace(5f);
	       table.addCell(gender);
	       
	       
	       PdfPCell email= new PdfPCell(new Paragraph("Email :"+vehicleOwnerDetails.getEmail(),tableBody));
	       email.setBorderColor(BaseColor.BLACK);
	       email.setPaddingLeft(10);
	       email.setHorizontalAlignment(Element.ALIGN_LEFT);
	       email.setVerticalAlignment(Element.ALIGN_CENTER);
	       email.setBackgroundColor(BaseColor.WHITE);
	       email.setExtraParagraphSpace(5f);
	       table.addCell(email);
	       
	       PdfPCell dob= new PdfPCell(new Paragraph("DOB :"+vehicleOwnerDetails.getDob(),tableBody));
	       dob.setBorderColor(BaseColor.BLACK);
	       dob.setPaddingLeft(10);
	       dob.setHorizontalAlignment(Element.ALIGN_LEFT);
	       dob.setVerticalAlignment(Element.ALIGN_CENTER);
	       dob.setBackgroundColor(BaseColor.WHITE);
	       dob.setExtraParagraphSpace(5f);
	      table.addCell(dob);
	       
	      PdfPCell phoneNumber= new PdfPCell(new Paragraph("Phone Number :"+vehicleOwnerDetails.getPhoneNumber(),tableBody));
	      phoneNumber.setBorderColor(BaseColor.BLACK);
	      phoneNumber.setPaddingLeft(10);
	      phoneNumber.setHorizontalAlignment(Element.ALIGN_LEFT);
	      phoneNumber.setVerticalAlignment(Element.ALIGN_CENTER);
	      phoneNumber.setBackgroundColor(BaseColor.WHITE);
	      phoneNumber.setExtraParagraphSpace(5f);
	       table.addCell(phoneNumber);
	       
	       PdfPCell zzno= new PdfPCell(new Paragraph("SSNO  :"+vehicleOwnerDetails.getZzn(),tableBody));
	       zzno.setBorderColor(BaseColor.BLACK);
	       zzno.setPaddingLeft(10);
	       zzno.setHorizontalAlignment(Element.ALIGN_LEFT);
	       zzno.setVerticalAlignment(Element.ALIGN_CENTER);
	       zzno.setBackgroundColor(BaseColor.WHITE);
	       zzno.setExtraParagraphSpace(5f);
		   table.addCell(zzno);
		         
	       
	       
	       VehicleOwnerAddress  vehicleOwnerAddress= vehicleSummaryEntity.getVehicleOwnerAddress();
	       
		   PdfPCell  vhclOwnrAddr= new PdfPCell(new Paragraph("VehicleOwnerAddress",tableHeader));
		   vhclOwnrAddr.setBorderColor(BaseColor.BLACK);
		   vhclOwnrAddr.setPaddingLeft(10);
		   vhclOwnrAddr.setHorizontalAlignment(Element.ALIGN_CENTER);
		   vhclOwnrAddr.setVerticalAlignment(Element.ALIGN_CENTER);
		   vhclOwnrAddr.setBackgroundColor(BaseColor.GRAY);
		   vhclOwnrAddr.setExtraParagraphSpace(5f);
	       table.addCell(vhclOwnrAddr);
	       
	       
	       PdfPCell hno= new PdfPCell(new Paragraph("House No :"+vehicleOwnerAddress.getHouseNo(),tableBody));
	       hno.setBorderColor(BaseColor.BLACK);
	       hno.setPaddingLeft(10);
	       hno.setHorizontalAlignment(Element.ALIGN_LEFT);
	       hno.setVerticalAlignment(Element.ALIGN_CENTER);
	       hno.setBackgroundColor(BaseColor.WHITE);
	       hno.setExtraParagraphSpace(5f);
		   table.addCell(hno);
		   
		   PdfPCell street = new PdfPCell(new Paragraph("Street  :"+vehicleOwnerAddress.getStreetName(),tableBody));
		   street.setBorderColor(BaseColor.BLACK);
		   street.setPaddingLeft(10);
		   street.setHorizontalAlignment(Element.ALIGN_LEFT);
		   street.setVerticalAlignment(Element.ALIGN_CENTER);
		   street.setBackgroundColor(BaseColor.WHITE);
		   street.setExtraParagraphSpace(5f);
		   table.addCell(street);
		   
		   PdfPCell city = new PdfPCell(new Paragraph("City  :"+vehicleOwnerAddress.getCity(),tableBody));
		   city.setBorderColor(BaseColor.BLACK);
		   city.setPaddingLeft(10);
		   city.setHorizontalAlignment(Element.ALIGN_LEFT);
		   city.setVerticalAlignment(Element.ALIGN_CENTER);
		   city.setBackgroundColor(BaseColor.WHITE);
		   city.setExtraParagraphSpace(5f);
		   table.addCell(city);
		   
		   PdfPCell zipcode = new PdfPCell(new Paragraph("ZipCode  :"+vehicleOwnerAddress.getZipCode(),tableBody));
		   zipcode.setBorderColor(BaseColor.BLACK);
		   zipcode.setPaddingLeft(10);
		   zipcode.setHorizontalAlignment(Element.ALIGN_LEFT);
		   zipcode.setVerticalAlignment(Element.ALIGN_CENTER);
		   zipcode.setBackgroundColor(BaseColor.WHITE);
		   zipcode.setExtraParagraphSpace(5f);
		   table.addCell(zipcode);
		   
		   VehicleDetails vehicleDetails = vehicleSummaryEntity.getVehicleDetails();
		   
		   PdfPCell  vhclDtls= new PdfPCell(new Paragraph("Vehicle Details",tableHeader));
		   vhclDtls.setBorderColor(BaseColor.BLACK);
		   vhclDtls.setPaddingLeft(10);
		   vhclDtls.setHorizontalAlignment(Element.ALIGN_CENTER);
		   vhclDtls.setVerticalAlignment(Element.ALIGN_CENTER);
		   vhclDtls.setBackgroundColor(BaseColor.GRAY);
		   vhclDtls.setExtraParagraphSpace(5f);
	       table.addCell(vhclDtls);
		   
	       PdfPCell vehicleType = new PdfPCell(new Paragraph("Vehicle Type  :"+vehicleDetails.getVehicleType(),tableBody));
	       vehicleType.setBorderColor(BaseColor.BLACK);
	       vehicleType.setPaddingLeft(10);
	       vehicleType.setHorizontalAlignment(Element.ALIGN_LEFT);
	       vehicleType.setVerticalAlignment(Element.ALIGN_CENTER);
	       vehicleType.setBackgroundColor(BaseColor.WHITE);
	       vehicleType.setExtraParagraphSpace(5f);
		   table.addCell(vehicleType);
		   
		   PdfPCell mfgYear = new PdfPCell(new Paragraph("Manufacturing Year  :"+vehicleDetails.getMfgYear(),tableBody));
		   mfgYear.setBorderColor(BaseColor.BLACK);
		   mfgYear.setPaddingLeft(10);
		   mfgYear.setHorizontalAlignment(Element.ALIGN_LEFT);
		   mfgYear.setVerticalAlignment(Element.ALIGN_CENTER);
		   mfgYear.setBackgroundColor(BaseColor.WHITE);
		   mfgYear.setExtraParagraphSpace(5f);
		   table.addCell(mfgYear);
		   
		   PdfPCell brand = new PdfPCell(new Paragraph("Vehicle Brand  :"+vehicleDetails.getVehicleBrand(),tableBody));
		   brand.setBorderColor(BaseColor.BLACK);
		   brand.setPaddingLeft(10);
		   brand.setHorizontalAlignment(Element.ALIGN_LEFT);
		   brand.setVerticalAlignment(Element.ALIGN_CENTER);
		   brand.setBackgroundColor(BaseColor.WHITE);
		   brand.setExtraParagraphSpace(5f);
		   table.addCell(brand);
		   
		   VehicleRegDetails vehicleRegDetails = vehicleSummaryEntity.getVehicleRegDetails();
		   
		   PdfPCell  vhclRegDtls= new PdfPCell(new Paragraph("Vehicle Registration Details",tableHeader));
		   vhclRegDtls.setBorderColor(BaseColor.BLACK);
		   vhclRegDtls.setPaddingLeft(10);
		   vhclRegDtls.setHorizontalAlignment(Element.ALIGN_CENTER);
		   vhclRegDtls.setVerticalAlignment(Element.ALIGN_CENTER);
		   vhclRegDtls.setBackgroundColor(BaseColor.GRAY);
		   vhclRegDtls.setExtraParagraphSpace(5f);
	       table.addCell(vhclRegDtls);
		   
	       PdfPCell regCenter = new PdfPCell(new Paragraph("Vehicle Registration Center  :"+vehicleRegDetails.getRegCenter(),tableBody));
	       regCenter.setBorderColor(BaseColor.BLACK);
	       regCenter.setPaddingLeft(10);
	       regCenter.setHorizontalAlignment(Element.ALIGN_LEFT);
	       regCenter.setVerticalAlignment(Element.ALIGN_CENTER);
	       regCenter.setBackgroundColor(BaseColor.WHITE);
	       regCenter.setExtraParagraphSpace(5f);
		   table.addCell(regCenter);
		   
		   PdfPCell regNumber = new PdfPCell(new Paragraph("Vehicle Registration Number  :"+vehicleRegDetails.getVehicleRegNumber(),tableBody));
		   regNumber.setBorderColor(BaseColor.BLACK);
		   regNumber.setPaddingLeft(10);
		   regNumber.setHorizontalAlignment(Element.ALIGN_LEFT);
		   regNumber.setVerticalAlignment(Element.ALIGN_CENTER);
		   regNumber.setBackgroundColor(BaseColor.WHITE);
		   regNumber.setExtraParagraphSpace(5f);
		   table.addCell(regNumber);      
	       
	       
	       
		   PdfPCell  currDate= new PdfPCell(new Paragraph("date: "+new Date(),tableHeader));
		   currDate.setBorderColor(BaseColor.BLACK);
		   currDate.setPaddingLeft(30);
		   currDate.setHorizontalAlignment(Element.ALIGN_RIGHT);
		   currDate.setVerticalAlignment(Element.ALIGN_CENTER);
		   currDate.setBackgroundColor(BaseColor.GRAY);
		   currDate.setExtraParagraphSpace(5f);
	       table.addCell(currDate);
		   
	       
	       document.add(table);
	       document.close();
	       return true;
			
	
		}
		catch(Exception ex)
		{
			return false;
		}
	
	
	}
	   
}
