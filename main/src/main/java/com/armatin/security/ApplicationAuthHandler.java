package com.armatin.security;

import com.armatin.exceeption.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ApplicationAuthHandler implements AccessDeniedHandler, AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        ApiException apiException = new ApiException(
                exception.getMessage()
                ,HttpStatus.FORBIDDEN
                ,ZonedDateTime.now());
        Map<String, Object> data = new HashMap<>();
        response.setStatus(apiException.getStatus().value());
        response.getOutputStream()
                .println(objectMapper.writeValueAsString(apiException));
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ApiException apiException = new ApiException(
                exception.getMessage()
                ,HttpStatus.UNAUTHORIZED
                ,ZonedDateTime.now());
        Map<String, Object> data = new HashMap<>();
        response.setStatus(apiException.getStatus().value());
        response.getOutputStream()
                .println(objectMapper.writeValueAsString(apiException));
    }
}
