package com.demo.springwaffle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.springwaffle.filter.UserContextInjectionFilter;

@Configuration
public class FilterConfig {

	@Bean
	public UserContextInjectionFilter userContextInjectorFilter() {
		return new UserContextInjectionFilter();
	}

}
