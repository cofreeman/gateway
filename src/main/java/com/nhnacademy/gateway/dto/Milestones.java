package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Milestones {
    private Long milestoneId;
    private Projects projectId;
    private String milestoneName;
    private LocalDate startDate;
    private LocalDate endDate;
}
