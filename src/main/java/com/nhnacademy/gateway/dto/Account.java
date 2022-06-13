package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Account {
    private Long accountId;
    private String id;
    private String password;
    private String email;
}
