package com.likelion.hackaton.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(){
        log.info("home controller");
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
}
