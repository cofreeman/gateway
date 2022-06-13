package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tasks {
    private Long taskId;
    private Projects projects;
    private Milestones milestones;
    private String taskTitle;
    private String taskContent;
}