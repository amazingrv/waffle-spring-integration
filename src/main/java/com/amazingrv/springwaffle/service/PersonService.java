package com.amazingrv.springwaffle.service;

import com.amazingrv.springwaffle.dto.PersonDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author rjat3
 */
public interface PersonService {

    List<PersonDTO> getAllPersons(Pageable pageable);

    PersonDTO getPerson(String id);

    String createPerson(PersonDTO person);

    String updatePerson(PersonDTO person);

    String deletePerson(String id);
}
