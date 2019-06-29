package com.demo.springwaffle.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springwaffle.constants.PathConstants;

@RestController
@RequestMapping(PathConstants.PATH_API_TEST)
public class TestController {

	@GetMapping
	public String getPrincipal(Authentication auth) {
		return String.format("You are logged in as: %s", auth.getPrincipal());
	}

}
