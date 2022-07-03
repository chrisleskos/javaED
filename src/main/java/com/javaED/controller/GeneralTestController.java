package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.test.GeneralTest;
import com.javaED.model.test.TestAnswer;
import com.javaED.service.GeneralTestService;
import com.javaED.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/general_test")
public class GeneralTestController {

    private GeneralTestService generalTestService;
    private QuestionService questionService;

    @Autowired
    public GeneralTestController(GeneralTestService generalTestService, QuestionService questionService) {
        this.generalTestService = generalTestService;
        this.questionService = questionService;
    }

    @GetMapping
    public String getGeneralTest(Model model) {

        GeneralTest generalTest = generalTestService.getTest();

        model.addAttribute("generalTest", generalTest);
        return "general_test";
    }

    @ResponseBody
    @PostMapping
    public List<TestAnswer> submitTest(@RequestBody TestAnswer[] testAnswers){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        int score = generalTestService.checkTest(testAnswers, appUser);

        GeneralTest generalTest = new GeneralTest(score, appUser);

        generalTestService.saveTest(generalTest);

        return List.of(testAnswers);
    }
}
