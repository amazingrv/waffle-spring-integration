package com.demo.springwaffle.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springwaffle.constants.PathConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(PathConstants.PATH_API_TEST)
@Slf4j
public class TestController {

	@GetMapping
	public String getPrincipal(Authentication auth) {
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
		return String.format("You are logged in as: %s", auth.getPrincipal());
	}

}
