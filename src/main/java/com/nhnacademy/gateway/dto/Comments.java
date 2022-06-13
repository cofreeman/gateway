package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
public class Comments {

    private Long commentId;
    private Tasks tasks;
    private String commentContent;
    private Long userId;
    private String id;
}
