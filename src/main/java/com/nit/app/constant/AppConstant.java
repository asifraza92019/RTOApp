package com.nit.app.constant;

/**
 * 
 * @author Asif
 *  In this interface we are seperating all hard coded data
 */

public interface AppConstant {

	  /**
	   *  @param VEHICLE_OWNER_DETAILS
	   *  use to display vehicle owner details jsp page
	   */
	
	public final String VEHICLE_OWNER_DETAILS= "vehicle_owner_details";
	
	/**
	 * @param VEHICLE_OWNER_ADDRESS
	 *  use to display vehicle owner address jsp page 
	 */
	
	public final String VEHICLE_OWNER_ADDRESS= "vehicle_owner_address";
	
	/**
	 * @param VEHICLE_DETAILS
	 *  use to display vehicle details jsp page
	 */
	
	public final String VEHICLE_DETAILS= "vehicle_details";
	 
	 /**
	  * @param VEHICLE_REGISTRATION_DETAILS
	  * use to display vehicle registration details jsp page
	  */
	
	
	public final String VEHICLE_REGISTRATION_DETAILS= "vehicle_registration_details";
	
	/**
	 * @param VEHICLE_SUMMARY
	 * use to display vehicle summary jsp page
	 */
	public final String VEHICLE_SUMMARY= "vehicle_summary";
	
	 
	public final String REDIRECT_VEHICLE_OWNER_ADDRESS="redirect:/address/vehicleowneraddress";
	
	public final String REDIRECT_VEHICLE_DETAIL ="redirect: /vehicledetail/loadvehicledetails";
	
	public final String REDIRECT_VEHICLE_OWNER_DETAILS="redirect:/vehicle/index";

	public final String REDIRECT_VEHICLE_SUMMARY="redirect:/summary/handlesummary";
	
	public final String REDIRECT_VEHICLE_REGISTRATION_DETAILS="redirect:/vehicleReg/final";
	
	public final String VEHICLE_OWNER_ID= "vehicleOwnerId";
	
}
