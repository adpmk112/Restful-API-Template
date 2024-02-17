package com.spring.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.rest.datamodel.Person;
import com.spring.rest.dtomodel.PersonDto;
import com.spring.rest.dtomodel.PersonResponseDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	Person toPerson(PersonDto dto);
	
	PersonDto toPersonDto(Person person);
	List<PersonDto> toPersonDtoList(List<Person> personList);
	
	PersonResponseDto toPersonResponse(Person person);
	List<PersonResponseDto> toPersonResponseList(List<Person> personList);
}
