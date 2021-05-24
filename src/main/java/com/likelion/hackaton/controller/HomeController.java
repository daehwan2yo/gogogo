package com.likelion.hackaton.controller;

import com.likelion.hackaton.form.Api_AirForm;
import com.likelion.hackaton.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String get_airapi(Model model) throws Exception{
        Api_AirForm api_airForm = apiService.callApi_air();
        model.addAttribute("api_airForm",api_airForm);
        log.info("get air");
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        log.info("login controller");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(){
        log.info("signup controller");
        return "signup";
    }

    @RequestMapping("/about")
    public String about(){
        log.info("about page");
        return"about";
    }

    @RequestMapping("/information")
    public String information(){
        log.info("information page");
        return "information";
    }

    @RequestMapping("/notice")
    public String notice(){
        log.info("notice page");
        return "notice";
    }

}
