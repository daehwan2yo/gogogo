package com.likelion.hackaton.controller;

import com.likelion.hackaton.form.QuestionForm;
import com.likelion.hackaton.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/{questionNo}")
    public String nextQuestion(@PathVariable("questionNo")int questionNo,
                               Model model){
        QuestionForm questionForm = questionService.getQuestion(questionNo);
        model.addAttribute("questionForm",questionForm);
        log.info("get quesion : "+questionNo);
        return "question";
    }

    @GetMapping("/question")
    public String nextQuestion2(@RequestParam("questionNo") int questionNo,
                               Model model){

        if(questionNo == 7){
            return "result";
        }
        QuestionForm questionForm = questionService.getQuestion(questionNo);
        model.addAttribute("questionForm",questionForm);
        log.info("get quesion : "+questionNo);
        return "question";
    }
}
