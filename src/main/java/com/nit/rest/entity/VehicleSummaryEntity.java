package com.nit.rest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nit.model.VehicleDetails;
import com.nit.model.VehicleOwnerAddress;
import com.nit.model.VehicleOwnerDetails;
import com.nit.model.VehicleRegDetails;

@XmlRootElement(name="vehicle-summary")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"registration-details","owner-detials","owner-address","vechicle-details"})
public class VehicleSummaryEntity {

	 @XmlElement(name="registration-details")
	private VehicleRegDetails vehicleRegDetails;
	
	 @XmlElement(name="owner-address")
	private VehicleOwnerAddress vehicleOwnerAddress;
	
	 @XmlElement(name="owner-detials")
	private VehicleOwnerDetails vehicleOwnerDetails;
	
	     
	  @XmlElement(name="vechicle-details")
	 private VehicleDetails vehicleDetails;


	public VehicleSummaryEntity() {
		super();
	}


	public VehicleRegDetails getVehicleRegDetails() {
		return vehicleRegDetails;
	}


	public void setVehicleRegDetails(VehicleRegDetails vehicleRegDetails) {
		this.vehicleRegDetails = vehicleRegDetails;
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


	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}


	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}


	@Override
	public String toString() {
		return "VehicleSummaryEntity [vehicleRegDetails=" + vehicleRegDetails + ", vehicleOwnerAddress="
				+ vehicleOwnerAddress + ", vehicleOwnerDetails=" + vehicleOwnerDetails + ", vehicleDetails="
				+ vehicleDetails + "]";
	}
	  
}
