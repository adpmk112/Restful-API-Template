package com.spring.rest.mapper;

import org.mapstruct.Mapper;

import com.spring.rest.data.Person;
import com.spring.rest.model.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	Person toPerson(PersonDto dto);
}
