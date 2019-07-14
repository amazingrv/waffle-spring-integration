package com.demo.springwaffle.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import com.demo.springwaffle.mapper.PersonMapper;
import com.demo.springwaffle.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private PersonMapper mapper;

	public List<PersonDTO> getAllPersons(Pageable pageable) {
		List<PersonEntity> persons = repository.findAll(pageable).getContent();
		return persons.stream().filter(Objects::nonNull).map(mapper::personToPersonDTO).collect(Collectors.toList());
	}

}
