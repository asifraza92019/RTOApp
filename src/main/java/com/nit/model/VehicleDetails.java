package com.nit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 
 * @author Asif
 * @param VehicleDetails
 * This class is create to store VehicleDetails in the database
 */


@Entity
@Table(name="VEHICLE_DTLS")
public class VehicleDetails {

	
	 /**
	  * @param vehicleId
	  * this is primary key of vehicleDetails
	  */
	 @Id
	   @Column(name="vehicle_dtl_id")
	   @GeneratedValue(strategy = GenerationType.SEQUENCE,
	                     generator = "vehicle_dtl_id_generator")
	   @SequenceGenerator(name="vehicle_dtl_id_generator",
	                      initialValue = 1,
	                       allocationSize = 1,
	                       sequenceName = "VHCL_DTL_ID_SEQ")
	private Integer vehicleId;
	 
	 /**
	  * @param vehicleType
	  * this variable will store vehicleType
	  */
	 
	 @Column(name="vehicle_type")
	private String vehicleType;
	 
	   /**
	    * @param mfgYear
	    *  this will store manufacturing date
	    */
	 @Column(name= "mfg_year")
	private String mfgYear;
	 
	    /**
	     * @param vehicleBrand
	     * this variable will store vehicleBrand
	     */
	    @Column(name="vehicle_brand")
	private String vehicleBrand;
	    
	    /**
		 * @param createDate
		 * This variable will store creation time into db 
		 */
	    
	    @Temporal(TemporalType.TIMESTAMP)
		  @CreationTimestamp
		  @Column(name="create_date")
	private Date createDate;
	    
	    /**
		 * @param updateDate
		 * This variable will store updation time into db 
		 */
	    
	    @Temporal(TemporalType.TIMESTAMP)
		 @UpdateTimestamp
		 @Column(name="update_date")
	private Date updateDate;
	    
	    /**
	     * @param vehicleOwnerDetails
	     * this will maintain one to one relation between vehicle detail and
	     * vehicle owner details
	     */
	    
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		  @JoinColumn(name="vehicle_owner_id" , 
		  referencedColumnName ="vehicle_owner_id") 
		 private VehicleOwnerDetails vehicleOwnerDetails;
	    
	    
	public VehicleDetails() {
		super();
	}
	
	
	
	
	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}




	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}




	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(String mfgYear) {
		this.mfgYear = mfgYear;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	@Override
	public String toString() {
		return "VehicleDetails [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", mfgYear=" + mfgYear
				+ ", vehicleBrand=" + vehicleBrand + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}
	
	
	
}
