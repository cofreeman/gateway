package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.dto.Account;
import com.nhnacademy.gateway.dto.LoginRequest;
import com.nhnacademy.gateway.dto.SignUpRequest;

public interface UserService {
    Account login(LoginRequest loginRequest);

    Account singUp(SignUpRequest signUpRequest);
}
