package com.nhnacademy.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }


    @GetMapping("/signUp")
    public String getSignUpForm(){
        return "signUpForm";
    }

    @PostMapping("signUp")
    public String SignUp(){
        return "";
    }
}
