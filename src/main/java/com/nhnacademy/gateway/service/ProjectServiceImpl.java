package com.nhnacademy.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.gateway.dto.Account;
import com.nhnacademy.gateway.dto.ProjectCreateDto;
import com.nhnacademy.gateway.dto.ProjectModifyDto;
import com.nhnacademy.gateway.dto.Projects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private static String gateWayRequest = "";

    @Override
    public List<Projects> getProjects(String userId) {
        HttpHeaders httpHeaders = getHeader();

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Projects>> responseEntity = restTemplate.exchange("http://localhost:9090/users/" + userId + "/projects",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public Projects createProject(String userId, ProjectCreateDto projectCreateDto) {
        HttpHeaders httpHeaders = getHeader();

        try {
            gateWayRequest = mapper.writeValueAsString(projectCreateDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(gateWayRequest,httpHeaders);
        ResponseEntity<Projects> responseEntity = restTemplate.exchange("http://localhost:9090/users/" + userId + "/projects",
                HttpMethod.POST,
                httpEntity,
                Projects.class);
        return responseEntity.getBody();

    }

    @Override
    public Projects getProject(String userId,Long projectId) {
        HttpHeaders httpHeaders = getHeader();

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Projects> responseEntity = restTemplate.exchange("http://localhost:9090/users/" + userId + "/projects",
                HttpMethod.GET,
                httpEntity,
                Projects.class);
        return responseEntity.getBody();
    }


    @Override
    public Projects modifyProject(String userId, Long projectId, ProjectModifyDto projectModifyDto) {
        HttpHeaders httpHeaders = getHeader();

        try {
            gateWayRequest = mapper.writeValueAsString(projectModifyDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(gateWayRequest,httpHeaders);
        ResponseEntity<Projects> responseEntity = restTemplate.exchange("http://localhost:9090/users/" + userId + "/projects/" + projectId,
                HttpMethod.POST,
                httpEntity,
                Projects.class);
        return responseEntity.getBody();

    }   private HttpHeaders getHeader() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return httpHeaders;
    }

}
