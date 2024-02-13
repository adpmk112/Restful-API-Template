package com.spring.rest.mapper;

import org.mapstruct.Mapper;

import com.spring.rest.datamodel.Person;
import com.spring.rest.dtomodel.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	Person toPerson(PersonDto dto);
}
