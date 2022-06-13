package com.nhnacademy.gateway.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class Tags {
    private Long id;
    private Projects projects;
    private String tagName;
}
