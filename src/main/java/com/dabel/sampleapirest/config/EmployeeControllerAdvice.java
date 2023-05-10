package com.dabel.sampleapirest.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dabel.sampleapirest.exception.EmployeeNotFoundException;
import com.dabel.sampleapirest.model.EmployeeExceptionDTO;

/**
 * Configure our advice controller to catch all 
 * exceptions from a not found employee
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class)
	ResponseEntity<Object> handlerEmployee(EmployeeNotFoundException ex) {
		
		EmployeeExceptionDTO empError = new EmployeeExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND.name());
		return new ResponseEntity<Object>(empError, HttpStatus.NOT_FOUND);
	}
}
