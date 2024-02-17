package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto person) {

		ResponseEntity<Object> response = personService.save(person);

		return response;
	}

	@PutMapping
	public ResponseEntity<Object> updatePerson(@Valid @RequestBody PersonDto person) {

		ResponseEntity<Object> response = personService.update(person);

		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findPersonById(@PathVariable long id) {

		ResponseEntity<Object> response = personService.findById(id);

		return response;
	}

	@GetMapping
	public ResponseEntity<Object> findAllPeople() {

		ResponseEntity<Object> response = personService.findAll();
		
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable long id){
		
		ResponseEntity<Object> response = personService.delete(id);
		
		return response;
	}

}
