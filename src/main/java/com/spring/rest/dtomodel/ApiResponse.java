package com.spring.rest.dtomodel;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse implements Responsible{
	
	private String message;
	private Object data;
	
	public ApiResponse(String message, Responsible data) {
		this.message = message;
		this.data = data;
	}
	
	public ApiResponse(String message, List<? extends Responsible> data) {
		this.message = message;
		this.data = data;
	}
	
	public ApiResponse(String message) {
		this.message = message;
	}
}
