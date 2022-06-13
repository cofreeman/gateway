package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectCreateDto {
    private String projectName;
    private String id;
}
