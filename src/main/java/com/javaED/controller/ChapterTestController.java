package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import com.javaED.model.test.ChapterTest;
import com.javaED.service.ChapterTestService;
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

    @Autowired
    public ChapterTestController(ChapterTestService chapterTestService) {
        this.chapterTestService = chapterTestService;
    }

    @GetMapping
    public String getChapterTest(Model model, @RequestParam("c") Chapter chapter) {
        List<Section> sections = chapter.getSections();
        ChapterTest chapterTest = chapterTestService.getTest(sections);

        model.addAttribute("chapterTest", chapterTest);

        return "chapter_test";
    }

    @PostMapping( path = "/submit")
    public String submitTest(@RequestParam("c") Chapter chapter){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        return "home";
    }
}
