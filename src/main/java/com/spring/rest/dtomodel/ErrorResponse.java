package com.spring.rest.dtomodel;

import lombok.Data;

@Data
public class ErrorResponse implements Responsible {
	
	private String message;
	
	public ErrorResponse(String message) {
		this.message = message;
	}
}
