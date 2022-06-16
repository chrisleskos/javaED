package com.javaED.controller;

import com.javaED.model.test.GeneralTest;
import com.javaED.service.GeneralTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/general_test")
public class GeneralTestController {

    GeneralTestService generalTestService;

    @Autowired
    public GeneralTestController(GeneralTestService generalTestSertvice) {
        this.generalTestService = generalTestSertvice;
    }

    @GetMapping
    public String getGeneralTest(Model model) {

        GeneralTest generalTest = generalTestService.getTest();

        model.addAttribute("generalTest", generalTest);
        return "general_test";
    }
}
