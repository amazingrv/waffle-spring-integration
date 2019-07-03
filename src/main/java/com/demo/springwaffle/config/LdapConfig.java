package com.demo.springwaffle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

	@Bean
	public LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl("ldap://localhost:8389/dc=springframework,dc=org");
		contextSource.setAnonymousReadOnly(true);
		return contextSource;
	}

	@Bean
	@Autowired
	public LdapTemplate ldapTemplate(ContextSource contextSource) {
		LdapTemplate template = new LdapTemplate();
		template.setContextSource(contextSource);
		return template;
	}
}
