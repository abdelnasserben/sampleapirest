package com.dabel.sampleapirest.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dabel.sampleapirest.exception.EmployeeNotFoundException;

/**
 * Configure our advice controller to catch all 
 * exceptions from a not found employee
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlerEmployeeNotFoundException(EmployeeNotFoundException exception) {
		return exception.getMessage();
	}
}
