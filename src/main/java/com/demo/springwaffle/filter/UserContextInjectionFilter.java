package com.demo.springwaffle.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import waffle.servlet.WindowsPrincipal;
import waffle.spring.WindowsAuthenticationToken;

public class UserContextInjectionFilter extends GenericFilterBean {

	private static final Logger log = LoggerFactory.getLogger(UserContextInjectionFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		SecurityContext sec = SecurityContextHolder.getContext();
		Authentication authentication = sec.getAuthentication();

		if (authentication != null && authentication.getClass() == WindowsAuthenticationToken.class) {
			WindowsAuthenticationToken token = (WindowsAuthenticationToken) authentication;
			WindowsPrincipal principal = (WindowsPrincipal) token.getPrincipal();
			log.debug("Context injection started.");
			String[] parts = principal.getName().split(Pattern.quote("\\"));
			addRoleToAuthentication(token, true);
			sec.setAuthentication(token);
			log.debug("User context injection completed for user: {}", parts[1]);
		}

		chain.doFilter(request, response);
	}

	private void addRoleToAuthentication(WindowsAuthenticationToken authentication, boolean isAdmin) {
		authentication.getAuthorities().clear();
		authentication.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
		if (isAdmin) {
			authentication.getAuthorities().add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
	}
}
