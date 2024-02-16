package com.spring.rest.dtomodel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonDto {
	private long id;
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	private int age;
	
	private boolean isDelete;
}
