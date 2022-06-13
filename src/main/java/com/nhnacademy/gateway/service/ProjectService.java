package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.dto.ProjectCreateDto;
import com.nhnacademy.gateway.dto.ProjectModifyDto;
import com.nhnacademy.gateway.dto.Projects;

import java.util.List;

public interface ProjectService {
    List<Projects> getProjects(String accountId);

    Projects createProject(String toString, ProjectCreateDto projectCreateDto);

    Projects modifyProject(String toString,Long projectId, ProjectModifyDto projectModifyDto);

    Projects getProject(String toString, Long projectId);
}
