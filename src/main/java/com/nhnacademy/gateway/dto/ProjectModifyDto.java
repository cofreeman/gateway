package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectModifyDto {
    private String projectName;
    private String id;
}
