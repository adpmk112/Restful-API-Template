package com.spring.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.spring.rest.datamodel.Person;
import com.spring.rest.dtomodel.ApiResponse;
import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.exception.DataNotFoundException;
import com.spring.rest.mapper.PersonMapper;
import com.spring.rest.repo.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PersonService {

	private PersonRepository personRepo;

	private PersonMapper personMapper;

	public ResponseEntity<Object> savePerson(PersonDto dto) {

		Person person = personMapper.toPerson(dto);

		Person savedPerson = personRepo.save(person);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Person saved successfully", savedPerson));

	}

	public ResponseEntity<Object> findPersonById(PersonDto dto) {

		Person person = personMapper.toPerson(dto);

		Person searchedPerson = findPersonById(person);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Data found", searchedPerson));

	}

	public Person findPersonById(Person person) {

		return personRepo.findById(person.getId())
				.orElseThrow(() -> new DataNotFoundException());
	}

	public ResponseEntity<Object> updatePerson(PersonDto dto) {

		Person person = personMapper.toPerson(dto);

		findPersonById(person);

		Person updatedPerson = personRepo.save(person);

		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.body(new ApiResponse("Person updated successfully", updatedPerson));

	}
}
