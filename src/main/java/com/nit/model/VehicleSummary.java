package com.nit.model;



/**
 * 
 * @author Asif
 *  this class is design to get all the vehicle data 
 *  from all defined classes
 */


public class VehicleSummary {

	
	 /**
	  * @param vehicleDetails
	  * this variable will reteriev all data  from VehicleDetails
	  */
	  
	   private VehicleDetails vehicleDetails;
	   
	   /**
		  * @param vehicleDetails
		  * this variable will reteriev all data  from VehicleOwnerAddress
		  */
	  
	   private VehicleOwnerAddress vehicleOwnerAddress;
	   
	   
	   /**
		  * @param vehicleDetails
		  * this variable will reteriev all data  from VehicleOwnerDetails
		  */
	   private VehicleOwnerDetails vehicleOwnerDetails;

	public VehicleSummary() {
		super();
	}

	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public VehicleOwnerAddress getVehicleOwnerAddress() {
		return vehicleOwnerAddress;
	}

	public void setVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress) {
		this.vehicleOwnerAddress = vehicleOwnerAddress;
	}

	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}

	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}

	@Override
	public String toString() {
		return "VehicleSummary [vehicleDetails=" + vehicleDetails + ", vehicleOwnerAddress=" + vehicleOwnerAddress
				+ ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}
	   
	   
	   
	     
}
