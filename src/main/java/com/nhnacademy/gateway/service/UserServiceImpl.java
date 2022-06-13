package com.nhnacademy.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.gateway.dto.Account;
import com.nhnacademy.gateway.dto.LoginRequest;
import com.nhnacademy.gateway.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    @Override
    public Account login(LoginRequest loginRequest) {
        HttpHeaders httpHeaders = getHeader();
        String gateWayRequest = "";

        try {
            gateWayRequest = mapper.writeValueAsString(loginRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(gateWayRequest,httpHeaders);
        ResponseEntity<Account> responseEntity = restTemplate.exchange("http://localhost:9090/users/",
                HttpMethod.GET,
                httpEntity,
                Account.class);
        return responseEntity.getBody();
    }

    @Override
    public Account singUp(SignUpRequest signUpRequest) {
        HttpHeaders httpHeaders = getHeader();
        String gateWayRequest = "";

        try {
            gateWayRequest = mapper.writeValueAsString(signUpRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(gateWayRequest,httpHeaders);
        ResponseEntity<Account> responseEntity = restTemplate.exchange("http://localhost:9090/users/",
                HttpMethod.POST,
                httpEntity,
                Account.class);
        return responseEntity.getBody();
    }

    private HttpHeaders getHeader() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return httpHeaders;
    }
}
