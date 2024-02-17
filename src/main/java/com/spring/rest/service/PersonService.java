package com.spring.rest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.spring.rest.datamodel.Person;
import com.spring.rest.dtomodel.ApiResponse;
import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.dtomodel.PersonResponseDto;
import com.spring.rest.exception.DataNotFoundException;
import com.spring.rest.mapper.PersonMapper;
import com.spring.rest.repo.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PersonService implements CommonCRUDConfigurable<Person,PersonDto> {

	private PersonRepository personRepo;

	private PersonMapper personMapper;

	@Override
	public ResponseEntity<Object> save(PersonDto dto) {
		
		Person person = personMapper.toPerson(dto);
		
		Person savedPerson = personRepo.save(person);
		
		PersonResponseDto responseData = personMapper.toPersonResponse(savedPerson);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Person saved successfully", responseData));

	}

	@Override
	public ResponseEntity<Object> findById(long id) {

		Person searchedPerson = getById(id);
		
		PersonDto responseData = personMapper.toPersonDto(searchedPerson);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Data found", responseData));

	}
	
	@Override
	public Person getById(long id) {

		return personRepo.findByIdAndIsDeleteFalse(id).orElseThrow(() -> new DataNotFoundException());
	}

	@Override
	public ResponseEntity<Object> findAll() {

		List<Person> personList = personRepo.findAllByIsDeleteFalse();
		
		List<PersonDto> responseData = personMapper.toPersonDtoList(personList);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Data List retrieved successfully", responseData));
	}

	@Override
	public ResponseEntity<Object> update(PersonDto dto) {

		Person person = personMapper.toPerson(dto);

		getById(person.getId());

		Person updatedPerson = personRepo.save(person);
		
		PersonDto responseData = personMapper.toPersonDto(updatedPerson);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Person updated successfully", responseData));

	}

	@Override
	public ResponseEntity<Object> delete(long id) {
		
		Person searchedPerson = getById(id);
		
		searchedPerson.setDelete(true);
		
		personRepo.save(searchedPerson);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
}
