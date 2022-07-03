package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.test.TestAnswer;
import com.javaED.model.test.ChapterTest;
import com.javaED.service.ChapterTestService;
import com.javaED.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chapter/test")
public class ChapterTestController {

    private ChapterTestService chapterTestService;
    private QuestionService questionService;

    @Autowired
    public ChapterTestController(ChapterTestService chapterTestService, QuestionService questionService) {
        this.chapterTestService = chapterTestService;
        this.questionService = questionService;
    }

    @GetMapping
    public String getChapterTest(Model model, @RequestParam("c") Chapter chapter) {
        List<Section> sections = chapter.getSections();
        ChapterTest chapterTest = (ChapterTest)chapterTestService.getTest(sections);

        model.addAttribute("chapterTest", chapterTest);

        return "chapter_test";
    }

    @ResponseBody
    @PostMapping
    public List<TestAnswer> submitTest(@RequestParam("c") Chapter chapter, @RequestBody TestAnswer[] testAnswers){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        int score = chapterTestService.checkTest(testAnswers, appUser);

        ChapterTest submittedChapterTest = new ChapterTest(score, chapter, appUser);

        chapterTestService.saveTest(submittedChapterTest);

        return List.of(testAnswers);
    }
}
