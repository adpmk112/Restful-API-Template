package com.spring.rest.dtomodel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonResponseDto {
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	private int age;
}
