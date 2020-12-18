package com.amazingrv.springwaffle.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rjat3
 */
public final class ResponseUtils {
    private ResponseUtils() {
        // empty constructor
    }

    /**
     * Helper method to create response to be returned
     *
     * @param key
     * @param result
     * @return response
     */
    public static ResponseEntity<Object> getResponse(String key, Object result) {
        Map<String, Object> response = new HashMap<>();
        response.put(key, result);
        return ResponseEntity.ok(response);
    }

    /**
     * Helper method to create error response to be returned
     *
     * @param ex exception
     * @return error response
     */
    public static ResponseEntity<Object> getErrorResponse(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
