package com.demo.springwaffle.rest;

import java.awt.print.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springwaffle.vo.PersonListRespVO;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@GetMapping("/all")
	public PersonListRespVO getAllPersons(Pageable pageable) {
		PersonListRespVO response = new PersonListRespVO();
		return response;
	}
}
