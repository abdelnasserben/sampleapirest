package com.dabel.sampleapirest.model;

import lombok.Data;

@Data
public class EmployeeExceptionDTO {
	
	private String message, status;

	public EmployeeExceptionDTO(String message, String status) {

		this.message = message;
		this.status = status;
	}
	
}
