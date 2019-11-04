package com.nit.app.constant;

/**
 *   this interface written to define all constants
 * @author Asif
 *
 */


public interface AppConstant {

    /**
     *  @return vehicle_details
     */
	
	public static final String VEHICLE_DETAILS ="vehicle_details";
	
	
	/**
	 * @return vehicle_owner_address
	 */
	
	public static final String VEHICLE_OWNER_ADDRESS="vehicle_owner_address";
	
	/**
	 * @return vehicle_onwer_details
	 */
	public static final String VEHICLE_OWNER_DETAILS= "vehicle_owner_details";
	
	
	/**
	 * @return vehicle_reg_details
	 */
	public static final String VEHICLE_REGISTRATION_DETAILS= "vehicle_registration_details";
	
	/**
	 * @Return vehicle_summary 
	 */
	public static final String VEHICLE_SUMMARY= "vehicle_summary";
	
	/**
	 *  @return vehicleOwnerId
	 */
	public static final String VEHICLE_OWNER_ID= "vehicleOwnerId";
	
	/**
	 * @return vehicle_address_from
	 */
	public static final String REDIRECT_VEHICLE_OWNER_ADDRESS="redirect:/address/addressform";
	
	/**
	 * this will load vehicle details
	 * return 
	 */
	public static final String REDIRECT_VEHICLE_DETAILS="redirect:/vehicledetails/loadvehicledetails";
	
	/**
	 *   @return index
	 *   	 */
	public static final String REDIRECT_VEHICLE_OWNER_DETAILS="redirect:/vehicle/index";
	
	/**
	 * @return vehicle_summary
	 */
	public static final String REDIRECT_VEHICLE_SUMMARY= "redirect:/summary/handlesummary";
	
	/**
	 * @return error
	 */
	public static final String ERROR_PAGE= "error";
	
}
