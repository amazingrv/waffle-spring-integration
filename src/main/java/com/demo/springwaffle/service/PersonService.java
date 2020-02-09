package com.demo.springwaffle.service;

import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.entity.PersonEntity;
import com.demo.springwaffle.mapper.PersonMapper;
import com.demo.springwaffle.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public static final String ENTITY_NOT_FOUND = "Entity not found!";
    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    public List<PersonDTO> getAllPersons(Pageable pageable) {
        List<PersonEntity> persons = repository.findAll(pageable).getContent();
        return persons.stream().filter(Objects::nonNull).map(mapper::toPersonDTO).collect(Collectors.toList());
    }

    public PersonDTO getPerson(String id) {
        Optional<PersonEntity> personEntity = repository.findById(id);
        PersonEntity entity = personEntity.orElseThrow(() -> new RuntimeException(ENTITY_NOT_FOUND));
        return mapper.toPersonDTO(entity);
    }

    public String createPerson(PersonDTO person) {
        PersonEntity personEntity = repository.save(mapper.toPersonEntity(person));
        return personEntity.getUid();
    }

    public String updatePerson(PersonDTO person) {
        Optional<PersonEntity> personEntity = repository.findById(person.getUid());
        PersonEntity entity = personEntity.orElseThrow(() -> new RuntimeException(ENTITY_NOT_FOUND));
        repository.save(entity);
        return entity.getUid();
    }

    public String deletePerson(String id) {
        Optional<PersonEntity> personEntity = repository.findById(id);
        PersonEntity entity = personEntity.orElseThrow(() -> new RuntimeException(ENTITY_NOT_FOUND));
        repository.delete(entity);
        return id;
    }
}
