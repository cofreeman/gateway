package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Projects {
    private Long projectId;

    private String projectName;

    private ProjectState projectState;

    private Long userId;

    private String id;
}
