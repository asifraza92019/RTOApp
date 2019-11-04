package com.nit.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nit.app.constant.AppConstant;

/**
 *  this class is written for handling all type of exception
 * @author Asif
 *
 */
@ControllerAdvice
public class VehicleExceptionHandler {

	/**
	 *   method to handle any exception
	 * @return  error
	 */
	
	@ExceptionHandler(Exception.class)
	public String erorPage()
	{
		return AppConstant.ERROR_PAGE;
	}
	
}
