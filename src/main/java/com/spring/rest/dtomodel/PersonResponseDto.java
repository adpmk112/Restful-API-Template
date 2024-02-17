package com.spring.rest.dtomodel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonResponseDto implements Responsible {
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	private int age;
}
