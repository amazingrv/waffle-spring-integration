package com.demo.springwaffle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springwaffle.constants.PathConstants;
import com.demo.springwaffle.dto.PersonDTO;
import com.demo.springwaffle.dto.PersonListRespDTO;
import com.demo.springwaffle.dto.StatusDTO;
import com.demo.springwaffle.service.PersonService;

@RestController
@RequestMapping(PathConstants.PATH_API_PERSONS)
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public PersonListRespDTO getAllPersons(@PageableDefault(page = 0, size = 100) Pageable pageable) {
		PersonListRespDTO response = new PersonListRespDTO();
		StatusDTO status = new StatusDTO();
		List<PersonDTO> personList = service.getAllPersons(pageable);

		status.setCode(0);
		status.setMessage("Success");
		response.setPersonList(personList);
		response.setStatus(status);
		return response;
	}
}
