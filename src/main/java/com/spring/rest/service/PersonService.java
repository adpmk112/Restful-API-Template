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

public class PersonService {

	private PersonRepository personRepo;

	private PersonMapper personMapper;

	public ResponseEntity<Object> savePerson(PersonDto dto) {
		
		Person person = personMapper.toPerson(dto);
		
		Person savedPerson = personRepo.save(person);
		
		PersonResponseDto responseData = personMapper.toPersonResponse(savedPerson);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Person saved successfully", responseData));

	}

	public ResponseEntity<Object> findPersonById(long id) {

		Person searchedPerson = getPersonById(id);
		
		PersonDto responseData = personMapper.toPersonDto(searchedPerson);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Data found", responseData));

	}

	private Person getPersonById(long id) {

		return personRepo.findByIdAndIsDeleteFalse(id).orElseThrow(() -> new DataNotFoundException());
	}

	public ResponseEntity<Object> findAllPeople() {

		List<Person> personList = personRepo.findAllByIsDeleteFalse();
		
		List<PersonDto> responseData = personMapper.toPersonDtoList(personList);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Data List retrieved successfully", responseData));
	}

	public ResponseEntity<Object> updatePerson(PersonDto dto) {

		Person person = personMapper.toPerson(dto);

		getPersonById(person.getId());

		Person updatedPerson = personRepo.save(person);
		
		PersonDto responseData = personMapper.toPersonDto(updatedPerson);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Person updated successfully", responseData));

	}

	public ResponseEntity<Object> deletePerson(long id) {
		
		Person searchedPerson = getPersonById(id);
		
		searchedPerson.setDelete(true);
		
		personRepo.save(searchedPerson);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.body(new ApiResponse("Person deleted successfully", null));
		
	}
}
