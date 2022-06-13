package com.nhnacademy.gateway.controller;


import com.nhnacademy.gateway.dto.ProjectCreateDto;
import com.nhnacademy.gateway.dto.ProjectModifyDto;
import com.nhnacademy.gateway.dto.Projects;
import com.nhnacademy.gateway.dto.Tasks;
import com.nhnacademy.gateway.service.ProjectService;
import com.nhnacademy.gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;

    private static final String userId = "userId";
    //프로젝트 리스트가 있는 메인 화면
    @GetMapping("/projects")
    public String getProjects(Model model,
                              HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }
        List<Projects> projects = projectService.getProjects(httpSession.getAttribute(userId).toString());
        model.addAttribute(projects);
        return "projects/projects";
    }
    //생성폼의 입력값으로 프로젝트 생성후 메인화면
    @PostMapping("/projects")
    public String createProjects(Model model,
                                 HttpServletRequest httpServletRequest,
                                 @ModelAttribute ProjectCreateDto projectCreateDto){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }
        Projects project =
                projectService.createProject(httpSession.getAttribute(userId).toString(),projectCreateDto);
        model.addAttribute(project);
        return "redirect:/projects/projects";
    }
    //프로젝트 생성 폼
    @GetMapping("/projectsCreateForm")
    public String getCreateProjectsForm(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }
        return "/projects/projectCreateForm";
    }
    //프로젝트 변경 폼
    @GetMapping("/projectsModifyForm")
    public String getModifyProjectsForm(@RequestParam("projectId") Long projectId,
                                        Model model,
                                        HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }

        Projects project = projectService.getProject(httpSession.getAttribute(userId).toString(),projectId);
        model.addAttribute("project",project);
        return "projects/projectModifyForm";
    }
    //todo: 프로젝트 변경
    //이건 프로젝트 안에 들어가서 한다. 프로젝트 관리자가 아니면 변경 불가능
    @PostMapping("/projects/update")
    public String modifyProjects(HttpServletRequest httpServletRequest,
                                 @ModelAttribute ProjectModifyDto projectModifyDto,
                                 @RequestParam("projectId") Long projectId){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }
        Projects project = projectService.modifyProject(httpSession.getAttribute(userId).toString(),projectId,projectModifyDto);
        return "/projects?projectId="+ project.getProjectId();
    }
    //프로젝트 클릭하면 태스크 목록 페이지로 이동
    @GetMapping("/projects/{projectId}")
    public String viewProject(@PathVariable("projectId") Long projectId,
                                 Model model,
                                 HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        if (Objects.isNull(httpSession)){
            throw new IllegalArgumentException();
        }
        List<Tasks> tasks = taskService.getTasks(projectId);
        model.addAttribute(tasks);
        return "/tasks";
    }
}
