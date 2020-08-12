package com.amazingrv.springwaffle.service;

import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.entity.PersonEntity;
import com.amazingrv.springwaffle.mapper.PersonMapper;
import com.amazingrv.springwaffle.repo.PersonRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository repository;

    private final PersonMapper mapper;

    public PersonService(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PersonDTO> getAllPersons(Pageable pageable) {
        List<PersonEntity> persons = repository.findAll(pageable).getContent();
        return persons.stream().filter(Objects::nonNull).map(mapper::toPersonDTO).collect(Collectors.toList());
    }

    public PersonDTO getPerson(String id) {
        Optional<PersonEntity> personEntity = repository.findById(id);
        PersonEntity entity = personEntity.orElseThrow(EntityNotFoundException::new);
        return mapper.toPersonDTO(entity);
    }

    public String createPerson(PersonDTO person) {
        PersonEntity personEntity = repository.save(mapper.toPersonEntity(person));
        return personEntity.getUid();
    }

    public String updatePerson(PersonDTO person) {
        Optional<PersonEntity> personEntity = repository.findById(person.getUid());
        PersonEntity entity = personEntity.orElseThrow(EntityNotFoundException::new);
        repository.save(entity);
        return entity.getUid();
    }

    public String deletePerson(String id) {
        Optional<PersonEntity> personEntity = repository.findById(id);
        PersonEntity entity = personEntity.orElseThrow(EntityNotFoundException::new);
        repository.delete(entity);
        return id;
    }
}
