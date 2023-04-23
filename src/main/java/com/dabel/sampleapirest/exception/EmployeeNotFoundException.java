package com.dabel.sampleapirest.exception;

/**
 * Exception class for requests to a non-existent employee 
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
