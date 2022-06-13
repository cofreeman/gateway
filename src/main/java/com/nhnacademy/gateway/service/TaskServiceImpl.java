package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.dto.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Override
    public List<Tasks> getTasks(Long projectId) {
        return null;
    }
}
