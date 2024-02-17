package com.spring.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rest.dtomodel.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> handleUnexpectedException(DataNotFoundException ex){
	
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse("Requested data not found"));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleUnexpectedException(RuntimeException ex){
		
		// test log here
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponse("An unexpected error occured"));
	}
}
