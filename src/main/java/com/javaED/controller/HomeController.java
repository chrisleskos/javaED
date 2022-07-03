package com.javaED.controller;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ChapterService chapterService;

    @Autowired
    public HomeController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    public String getIndex(Model model){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();

        List<Chapter> chapters = chapterService.getChapters(appUser);

        boolean openGeneralTest= true;

        for(Chapter c : chapters) {
            if(!c.isUnlocked()){
                openGeneralTest = false;
                break;
            }
        }
        model.addAttribute("user", appUser);
        model.addAttribute("chapters", chapters);
        model.addAttribute("openGeneralTest", openGeneralTest);
        return "home";
    }
}
