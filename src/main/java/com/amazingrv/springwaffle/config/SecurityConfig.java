package com.amazingrv.springwaffle.config;

import com.amazingrv.springwaffle.filter.UserContextInjectionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import waffle.spring.NegotiateSecurityFilter;
import waffle.spring.NegotiateSecurityFilterEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final NegotiateSecurityFilter negotiateSecurityFilter;

    private final NegotiateSecurityFilterEntryPoint entryPoint;

    private final UserContextInjectionFilter userContextInjectorFilter;

    public SecurityConfig(NegotiateSecurityFilter negotiateSecurityFilter,
                          NegotiateSecurityFilterEntryPoint entryPoint,
                          UserContextInjectionFilter userContextInjectorFilter) {
        this.negotiateSecurityFilter = negotiateSecurityFilter;
        this.entryPoint = entryPoint;
        this.userContextInjectorFilter = userContextInjectorFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().csrfTokenRepository(new CookieCsrfTokenRepository())
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(entryPoint)
                .and().addFilterAfter(negotiateSecurityFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(userContextInjectorFilter, BasicAuthenticationFilter.class);
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

}