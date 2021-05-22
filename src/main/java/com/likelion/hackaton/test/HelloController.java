package com.likelion.hackaton.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String hello(Model model){
        model.addAttribute("data","Hello");

        // 자동으로 template 화면으로 가짐
        // 관례상 Hello.html 자동으로 됨
        // 결과가 화면으로 렌더링됨
        return "hello";

        // 스프링 부트 thymleaf viewName 매핑
        // resources:templates/ + {ViewName} + .html
    }
}
