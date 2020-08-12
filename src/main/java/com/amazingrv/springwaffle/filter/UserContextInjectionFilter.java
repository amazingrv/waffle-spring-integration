package com.amazingrv.springwaffle.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import waffle.servlet.WindowsPrincipal;
import waffle.spring.WindowsAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Slf4j
@Component
public class UserContextInjectionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        SecurityContext sec = SecurityContextHolder.getContext();
        Authentication authentication = sec.getAuthentication();

        if (authentication != null && authentication.getClass() == WindowsAuthenticationToken.class) {
            WindowsAuthenticationToken token = (WindowsAuthenticationToken) authentication;
            WindowsPrincipal principal = (WindowsPrincipal) token.getPrincipal();
            log.debug("Context injection started.");
            String[] parts = principal.getName().split(Pattern.quote("\\"));
            // update admin value based on DB authentication
            boolean isAdmin = true;
            addRoleToAuthentication(token, isAdmin);
            sec.setAuthentication(token);
            log.debug("User context injection completed for user: {}", parts[1]);
        }

        filterChain.doFilter(request, response);
    }

    private void addRoleToAuthentication(WindowsAuthenticationToken authentication, boolean isAdmin) {
        authentication.getAuthorities().clear();
        authentication.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        if (isAdmin) {
            authentication.getAuthorities().add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
    }
}
