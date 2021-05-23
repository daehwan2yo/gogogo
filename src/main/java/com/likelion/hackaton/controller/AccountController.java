package com.likelion.hackaton.controller;

import com.likelion.hackaton.form.AccountForm;
import com.likelion.hackaton.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/signup")
    public String getSignup(Model model){
        model.addAttribute("accountForm",new AccountForm());
        log.info("get signup");
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@Valid AccountForm accountForm, BindingResult result){

        if(result.hasErrors()){
            return "/signup";
        }
        accountService.signup(accountForm);
        log.info("post signup");
        return "redirect:/";
    }
}
