package com.spring.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.rest.data.Person;
import com.spring.rest.mapper.PersonMapper;
import com.spring.rest.model.ApiResponse;
import com.spring.rest.model.PersonDto;
import com.spring.rest.repo.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonService {
	
	private PersonRepository personRepo;
	
	private PersonMapper personMapper;

	public ResponseEntity<Object> savePerson(PersonDto dto){
		try {
			Person person = personMapper.toPerson(dto);
			
			Person savedPerson = personRepo.save(person);
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new ApiResponse("Person saved successfully", savedPerson));
		}
		catch(Exception e){
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse("Failed to save person : " + e.getMessage(), null));
		}
	}
}
 