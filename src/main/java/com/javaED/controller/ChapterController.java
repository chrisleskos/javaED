package com.javaED.controller;

import com.javaED.model.material.Chapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("chapter")
public class ChapterController {

    @GetMapping
    public String getChapterSections(@RequestParam(name = "c") Chapter chapter, Model model) {
        model.addAttribute("chapter", chapter);

        return "chapter";
    }
}
