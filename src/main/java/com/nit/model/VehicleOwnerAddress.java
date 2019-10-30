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
 * @Param 
 * this class will persist Vehicle owner address in the database
 */

@Entity
@Table(name="VEHICLE_OWNER_ADDRESS_DTLS")
public class VehicleOwnerAddress {

	/**
	 * @param addressId
	 * this variable will store vehicle owner address id 
	 */
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	                 generator = "address_id_generator")
	@SequenceGenerator(name = "address_id_generator",
	                   initialValue = 1,
	                    allocationSize = 1,
	                    sequenceName = "ADRS_ID_SEQ")
	private Integer addressId;
	
	/**
	 * @param houseNo
	 * this variable will store house number of vehicle owner
	 * 
	 */
	
	@Column(name="hno")
	private String  houseNo;
	 
	 /**
	  * @param 
	  * this variable will store street name of owner address
	  */
	
	 @Column(name="street_name")
	private String  streetName;
	 
	  /**
	   * @param city
	   * this variable will store city of the owner address
	   */
	 @Column(name="city")
	private String  city;
	 
	 /**
	  * @param zipCode
	  *  this will store zipCode of the onwer address
	  */
	 @Column(name="zipcode")
	private String  zipCode;
	
	 
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
	   * this will maintain one to one relation between VehicleOwnerDetail 
	   * and VehicleOwnerAddress
	   */

	  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinColumn(name="vehicle_owner_id",
	  referencedColumnName ="vehicle_owner_id")  
	   private  VehicleOwnerDetails vehicleOwnerDetails;

	 
	 
	 
	 
	 
	public VehicleOwnerAddress() {
		super();
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	
	
	
	
	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}

	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}

	@Override
	public String toString() {
		return "VehicleOwnerAddress [addressId=" + addressId + ", houseNo=" + houseNo + ", streetName=" + streetName
				+ ", city=" + city + ", zipCode=" + zipCode + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}

	
	
	
}
