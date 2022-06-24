package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.SubmittedChapterTest;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.test.TestAnswer;
import com.javaED.model.test.ChapterTest;
import com.javaED.service.ChapterTestService;
import com.javaED.service.QuestionService;
import com.javaED.service.SubmitChapterTestService;
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
    private SubmitChapterTestService submitChapterTestService;
    private QuestionService questionService;

    @Autowired
    public ChapterTestController(ChapterTestService chapterTestService, SubmitChapterTestService submitChapterTestService, QuestionService questionService) {
        this.chapterTestService = chapterTestService;
        this.submitChapterTestService = submitChapterTestService;
        this.questionService = questionService;
    }

    @GetMapping
    public String getChapterTest(Model model, @RequestParam("c") Chapter chapter) {
        List<Section> sections = chapter.getSections();
        ChapterTest chapterTest = chapterTestService.getTest(sections);

        model.addAttribute("chapterTest", chapterTest);

        return "chapter_test";
    }

    @PostMapping
    public List<TestAnswer> submitTest(@RequestParam("c") Chapter chapter, @RequestBody TestAnswer[] testAnswers){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        int score = chapterTestService.checkTest(testAnswers, appUser);

        SubmittedChapterTest submittedChapterTest = new SubmittedChapterTest(score, chapter, appUser);

        submitChapterTestService.saveChapterTest(submittedChapterTest);

        return List.of(testAnswers);
    }
}
