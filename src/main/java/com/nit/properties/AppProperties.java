package com.nit.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * this class act like caching to store most frequesnt data 
 */

@Component
@ConfigurationProperties(prefix = "form-app")
public class AppProperties {

	/**
	 *   defining mapp to store data in the form of key value pair
	 */
	public Map<String , String > message;

	/**
	 *  defined public constructor
	 */
	public AppProperties() {
		super();
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AppProperties [message=" + message + "]";
	}
	
	
}
