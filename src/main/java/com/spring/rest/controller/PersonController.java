package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/people")
	public ResponseEntity<Object> createPerson(@RequestBody PersonDto person){
		
		log.info("Request --> "+person);
		
		ResponseEntity<Object> response = personService.savePerson(person);
		
		return response;
	}

}
