package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.dto.Account;
import com.nhnacademy.gateway.dto.LoginRequest;
import com.nhnacademy.gateway.dto.Projects;
import com.nhnacademy.gateway.dto.SignUpRequest;
import com.nhnacademy.gateway.service.ProjectService;
import com.nhnacademy.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginSingUpController {

    private final UserService userService;
    private final ProjectService projectService;


    @GetMapping("/login")
    public String getLoginForm(){
        return "loginForm";
    }

    //todo: 자신의 상태를 변경할 수 있는 링크와 로그아웃 버튼 구현
    //로그인을 하면 프로젝트 리스트가 있는 메인 화면으로 간다.
    @PostMapping("/login")
    public String getLoginForm(@ModelAttribute @Valid LoginRequest loginRequest,
                               Model model,
                               HttpServletRequest httpServletRequest,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        HttpSession httpSession = httpServletRequest.getSession(true);
        Account account = userService.login(loginRequest);
        httpSession.setAttribute("userId",account.getAccountId());
        model.addAttribute(account);
        List<Projects> projects = projectService.getProjects(account.getAccountId().toString());
        model.addAttribute(projects);
        return "main";
    }

    @GetMapping("/signUp")
    public String getSignUpForm(){
        return "signUpForm";
    }

    @PostMapping("/signUp")
    public String SignUp(@ModelAttribute SignUpRequest signUpRequest,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        userService.singUp(signUpRequest);
        return "/";
    }
}
