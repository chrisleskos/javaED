package com.javaED.controller;

import com.javaED.model.material.Chapter;
import com.javaED.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Chapter> chapters = chapterService.getChapters();
        model.addAttribute("chapters", chapters);
        return "home";
    }
}
