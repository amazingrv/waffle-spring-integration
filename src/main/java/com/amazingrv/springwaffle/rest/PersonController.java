package com.amazingrv.springwaffle.rest;

import com.amazingrv.springwaffle.constants.Routes;
import com.amazingrv.springwaffle.dto.PersonDTO;
import com.amazingrv.springwaffle.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static com.amazingrv.springwaffle.constants.Constants.*;
import static com.amazingrv.springwaffle.rest.util.ResponseUtils.getErrorResponse;
import static com.amazingrv.springwaffle.rest.util.ResponseUtils.getResponse;

/**
 * @author rjat3
 */
@RestController
@RequestMapping(Routes.API_PERSON)
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * End point to fetch all persons from db
     *
     * @param pageable pagination details
     * @return response
     */
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPersons(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        try {
            List<PersonDTO> persons = service.getAllPersons(pageable);
            return getResponse(PERSONS, persons);
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    /**
     * End point to fetch a persons from db based on id
     *
     * @param id key for person to fetch
     * @return response
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPerson(@PathVariable("id") String id) {
        try {
            PersonDTO person = service.getPerson(id);
            return getResponse(PERSON, person);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    /**
     * End point to insert a person in db based on details received
     *
     * @param person person details
     * @return response
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> savePersonToDB(@Valid @RequestBody PersonDTO person) {
        try {
            String userId = service.createPerson(person);
            return getResponse(USER_ID, userId);
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    /**
     * End point to update person details in db based on details received
     *
     * @param person person details
     * @return response
     */
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editPersonInDB(@RequestBody PersonDTO person) {
        try {
            String userId = service.updatePerson(person);
            return getResponse(USER_ID, userId);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }

    /**
     * End point to delete person from db based on id
     *
     * @param id key for person to delete
     * @return response
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deletePersonFromDB(@PathVariable String id) {
        try {
            String userId = service.deletePerson(id);
            return getResponse(USER_ID, userId);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return getErrorResponse(ex);
        }
    }
}
