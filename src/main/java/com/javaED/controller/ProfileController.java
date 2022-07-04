package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.test.ChapterTest;
import com.javaED.model.test.GeneralTest;
import com.javaED.service.ChapterService;
import com.javaED.service.ChapterTestService;
import com.javaED.service.GeneralTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final ChapterTestService chapterTestService;
    private final GeneralTestService generalTestService;
    private final ChapterService chapterService;

    @Autowired
    public ProfileController(ChapterTestService chapterTestService, GeneralTestService generalTestService, ChapterService chapterService) {
        this.chapterTestService = chapterTestService;
        this.generalTestService = generalTestService;
        this.chapterService = chapterService;
    }

    @GetMapping
    public String getProfile(Model model) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        List<Chapter> chapters = chapterService.getChapters(appUser);

        List<GeneralTest> generalTests = generalTestService.bestTest(appUser);

        for (Chapter chapter:
             chapters) {
            List<ChapterTest> chapterTests = chapterTestService.bestTest(chapter, appUser);
        }

        model.addAttribute("user", appUser);

        return "profile";
    }
}
