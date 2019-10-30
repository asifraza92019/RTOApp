package com.nit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 *  @param VehicleRegDetails
 *  this class will store VehicleRegDetails into database
 */

@Table(name="Vehicle_Reg_dtls")
@Entity
public class VehicleRegDetails {

	  /**
	   * @param regid
	   * this variable act as a primary key in Vehicle_Reg_dtls table
	   */
	 @Id
	 @Column(name="vehicle_reg_id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE,
	                 generator = "vehicle_reg_id_generator")
	 @SequenceGenerator(name = "vehicle_reg_id_generator" ,
	                    initialValue = 1,
	                    allocationSize = 1,
	                    sequenceName = "VHCL_REG_ID_SEQ")
	private Integer RegId;
	 
	 /**
	  * @param regDate
	  * this variable will store registration date
	  */
	 
	 @Temporal(TemporalType.DATE)
	 @CreationTimestamp
	 @Column(name="reg_date")
	private  Date   regDate;
	 
	 /**
	  * @param regCenter
	  *  this variable will store registration center
	  */
	  @Column(name="reg_center")
	private  String regCenter;
	  
	  
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
	   * param vehicleRegNumber
	   * this will store vehicle registrationnumber
	   */
	  @Column(name="vehicle_reg_num")
	  private String vehicleRegNumber;
	
	   /**
	    * @param vehicleOwnerDetails
	    * this will maintain one to one relation 
	    */
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="vehicle_owner_id",
	  referencedColumnName = "vehicle_owner_id" )
	  private VehicleOwnerDetails vehicleOwnerDetails;

	
	
	
	public VehicleRegDetails() {
		super();
	}
	public Integer getRegId() {
		return RegId;
	}
	public void setRegId(Integer regId) {
		RegId = regId;
	}
	
	
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRegCenter() {
		return regCenter;
	}
	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
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
	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}
	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	
	
	
	
	
	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}
	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}
	
	
	@Override
	public String toString() {
		return "VehicleRegDetails [RegId=" + RegId + ", regDate=" + regDate + ", regCenter=" + regCenter
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", vehicleRegNumber=" + vehicleRegNumber
				+ ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}
	
	
	
	
}
