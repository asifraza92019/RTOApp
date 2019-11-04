package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Asif
 * This class is created to store vehicle owner details
 */


@Entity
@Table(name="VEHICLE_OWNER_DTS")
public class VehicleOwnerDetails {

	/**
	 *  @param vehicleOwnerId 
	 *  it will generate primary key
	 */
	
	  @Id
	  @Column(name= "vehicle_owner_id")
	  @GeneratedValue(strategy = GenerationType.SEQUENCE,
	   generator = "vehicle_owner_id_generator")
	  @SequenceGenerator(name="vehicle_owner_id_generator",
	                     initialValue = 1,
	                     allocationSize = 1,
	                     sequenceName = "VHCL_OWNR_ID_SEQ")
	private Integer vehicleOwnerId;
	
	  /**
	   * @param firstName
	   * this will store first name of the vehicle owner
	   */
	@Column(name= "first_name")
	//@Size(min = 2, max =20 ,message = "size must be between 2 to 20 character")
	//@Pattern(regexp = "[a-zA-Z] {2,20}")
	private String firstName;
	
	
	 /**
	  * @param lastName
	  * this variable is define to store last name of the vehicle owner
	  */
	//@Size(min = 2, max =20 ,message = "size must be between 2 to 20 character")
	//@Pattern(regexp = "[a-zA-Z] {2,20}")
	@Column(name="last_name")
	private String lastName;
	
	/**
	 *  @param gender
	 *  This variable will store gender 
	 */
	
	//@NotEmpty(message = "gender must not be empty")
	@Column(name="gender")
	private String gender;
	
	/**
	 *  @param  email
	 * this will store email of vehicle owner
	 */
	@Column(name="email")
	//@Email(message = "enter valid email id")
	private String email;
	
	/**
	 * @param dob
	 * this variable is define to store date of birth of vehice owner
	 */
	
	@Column(name="dob")
	//@DateTimeFormat(pattern = "dd/MMM/yyyy")
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
	private String dob;
	
	/**
	 *  @param phoneNumber
	 *  this variable is define to store mobile number of vehicle owner 
	 */
	
	@Column(name="phno")
	//@Size(max = 10, min = 10 ,message = "mobile number should be of 10 digit")
	//@Pattern(regexp ="[0-9] {10}")	
	private String phoneNumber;
	
	
	   /**
	    * @param zzn
	    * this will store ssn number of vehicle owner
	    */
	//@Size(min = 9, max = 11)
	//@NotEmpty(message = "ssn number should not exceed 9 digit")
	@Column(name="ssn")
	private String zzn;
	
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
        * @param VehicleOwnerAddress
        * this variable is define to maintain one to one relation 
        *  between vehicleOwnerAddres and vehicleOwnerDetails
        */
     @OneToOne(mappedBy = "vehicleOwnerDetails")
   private VehicleOwnerAddress vehicleOwnerAddress;
 
     
     /**
      * @param vehicleDetails
      * this variable is define to maintain one to one relation 
      *  between VehicleDetails and vehicleOwnerDetails
      */
       @OneToOne(mappedBy = "vehicleOwnerDetails")
        private VehicleDetails vehicleDetails;

       /**
        * @param vehicleRegDetails
        * this variable is define to maintain one to one relation 
        *  between VehicleRegDetails and vehicleOwnerDetails
        */
       
        @OneToOne(mappedBy="vehicleOwnerDetails")
       private VehicleRegDetails vehicleRegDetails;
        
    	
	public VehicleOwnerDetails() {
		super();
	}
	public Integer getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(Integer vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}
	
	
	
	public String getZzn() {
		return zzn;
	}
	public void setZzn(String zzn) {
		this.zzn = zzn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return "VehicleOwnerDetails [vehicleOwnerId=" + vehicleOwnerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", email=" + email + ", dob=" + dob + ", phoneNumber=" + phoneNumber
				+ ", zzn=" + zzn + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
}
