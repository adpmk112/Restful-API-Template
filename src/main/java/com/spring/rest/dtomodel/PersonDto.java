package com.spring.rest.dtomodel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonDto implements Responsible {
	private long id;
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	private int age;
}
