package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto person){
		
		ResponseEntity<Object> response = personService.savePerson(person);
		
		return response;
	}
	
	@PutMapping
	public ResponseEntity<Object> updatePerson(@Valid @RequestBody PersonDto person){
		
		ResponseEntity<Object> response = personService.updatePerson(person);
		
		return response;
	}

}
