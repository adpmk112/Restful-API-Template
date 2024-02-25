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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.service.PersonService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/people")
@Slf4j
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto person) {

		return personService.save(person);
	}

	@PutMapping
	public ResponseEntity<Object> updatePerson(@Valid @RequestBody PersonDto person) {

		return personService.update(person);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findPersonById(@PathVariable long id) {

		return personService.findById(id);
	}

	@GetMapping
	public ResponseEntity<Object> findAllPeople() {

		return personService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable long id) {

		return personService.delete(id);
	}

	@GetMapping("/search")
	public ResponseEntity<Object> advancedSearch(@RequestParam(required = false) String name,
												 @RequestParam(defaultValue = "0") Integer age) {
		log.info(name + " and " + age);
		return personService.advancedSearch(name, age);
	}
}
