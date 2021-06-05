package com.likelion.hackaton.controller;

import com.likelion.hackaton.entity.Account;
import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.exception.CityNotFoundException;
import com.likelion.hackaton.exception.UserNotFoundException;
import com.likelion.hackaton.form.QuestionForm;
import com.likelion.hackaton.repository.AccountRepository;
import com.likelion.hackaton.repository.CityRepository;
import com.likelion.hackaton.repository.TitleRepository;
import com.likelion.hackaton.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    private final AccountRepository accountRepository;
    private final CityRepository cityRepository;
    private final TitleRepository titleRepository;

    @GetMapping("/question/{questionNo}")
    public String nextQuestion(@PathVariable("questionNo")int questionNo,
                               Model model){
        QuestionForm questionForm = questionService.getQuestion(questionNo);
        model.addAttribute("questionForm",questionForm);
        log.info("get quesion : "+questionNo);
        return "question";
    }

    @Transactional
    @GetMapping("/question")
    public String nextQuestion2(@RequestParam("questionNo") int questionNo,
                               Model model){

        if(questionNo == 7){
            try {
                String userId = SecurityContextHolder.getContext().getAuthentication().getName();
                log.info(userId);
                Account account = accountRepository.findByName(userId).orElseThrow(UserNotFoundException::new);

                City city = cityRepository.findByName(account.getCityName()).orElseThrow(CityNotFoundException::new);

                int rand = (int)(Math.random()*10);

                if(rand>6){
                    int imp = city.getTodo_1();
                    city.setTodo_1(++imp);
                    city.getTitle().setBadge_1(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result";

                }
                else if (rand ==1){
                    int imp = city.getTodo_2();
                    city.setTodo_1(++imp);
                    city.getTitle().setBadge_1(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result";
                }
                else if (rand ==2) {
                    int imp = city.getTodo_3();
                    city.setTodo_2(++imp);
                    city.getTitle().setBadge_2(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result2";
                }
                else if (rand ==3){
                    int imp = city.getTodo_3();
                    city.setTodo_3(++imp);
                    city.getTitle().setBadge_3(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result3";

                }
                else if (rand ==4){
                    int imp = city.getTodo_4();
                    city.setTodo_4(++imp);
                    city.getTitle().setBadge_4(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result4";

                }
                else if (rand ==5) {
                    int imp = city.getTodo_5();
                    city.setTodo_5(++imp);
                    city.getTitle().setBadge_5(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result5";
                }
                else if (rand ==6) {
                    int imp = city.getTodo_1();
                    city.setTodo_6(++imp);
                    city.getTitle().setBadge_6(imp);
                    cityRepository.flush();
                    titleRepository.flush();
                    return "result6";
                }

            }catch (UserNotFoundException u){
                return "result";
            }
        }

        QuestionForm questionForm = questionService.getQuestion(questionNo);
        model.addAttribute("questionForm",questionForm);
        log.info("get quesion : "+questionNo);
        return "question";
    }
}
