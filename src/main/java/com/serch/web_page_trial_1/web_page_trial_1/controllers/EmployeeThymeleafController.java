package com.serch.web_page_trial_1.web_page_trial_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/employees")
public class EmployeeThymeleafController {

    @ResponseBody
    @GetMapping("/prueba")
    public String prueba() {
        return "funiona";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/seeEmployees")
    public String seeEmployees(){
        return "seeEmployees";
    }

}
