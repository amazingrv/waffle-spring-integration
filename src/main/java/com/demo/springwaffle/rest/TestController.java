package com.demo.springwaffle.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springwaffle.constants.PathConstants;

@CrossOrigin(allowCredentials = "true", origins = { "http://localhost:9060" })
@RestController
@RequestMapping(PathConstants.PATH_API_TEST)
public class TestController {

	@GetMapping
	public String getPrincipal(Authentication auth) {
		return String.format("You are logged in as: %s with roles %s", auth.getPrincipal(),
				auth.getAuthorities().toString());
	}

}
