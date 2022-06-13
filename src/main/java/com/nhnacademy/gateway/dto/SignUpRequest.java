package com.nhnacademy.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Length(min = 1, max = 20)
    private String id;

    @NotBlank
    @Length(min = 1, max = 20)
    private String password;

    @NotBlank
    @Email
    private String email;
}
