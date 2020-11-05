package com.amazingrv.springwaffle.rest;

import com.amazingrv.springwaffle.constants.PathConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PathConstants.API_AUTH)
public class AuthTestController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPrincipal(Authentication auth) {
        Map<String, String> response = new HashMap<>();
        String message = String.format("You are logged in as: %s with roles %s", auth.getPrincipal(),
                auth.getAuthorities().toString());
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}
