package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.dto.Tasks;

import java.util.List;

public interface TaskService {
    List<Tasks> getTasks(Long projectId);
}
