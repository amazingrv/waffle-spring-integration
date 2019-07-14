package com.demo.springwaffle.mapper;

import org.springframework.stereotype.Component;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;

@Component
public class PersonMapper {

	public PersonDTO personToPersonDTO(PersonEntity person) {
		PersonDTO dto = new PersonDTO();
		dto.setUid(person.getUid());
		dto.setFirstName(person.getFirstName());
		return dto;
	}
}
