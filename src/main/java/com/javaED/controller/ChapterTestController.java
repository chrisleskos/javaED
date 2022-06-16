package com.javaED.controller;

import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import com.javaED.model.test.ChapterTest;
import com.javaED.service.ChapterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chapter_test")
public class ChapterTestController {

    private ChapterTestService chapterTestService;

    @Autowired
    public ChapterTestController(ChapterTestService chapterTestService) {
        this.chapterTestService = chapterTestService;
    }

    @GetMapping( path = "{c}")
    public String getChapterTest(Model model, @PathVariable("c") Chapter chapter) {
        List<Section> sections = chapter.getSections();
        ChapterTest chapterTest = chapterTestService.getTest(sections);

        model.addAttribute("chapterTest", chapterTest);

        return "chapter_test";
    }

    @PostMapping( path = "{c}")
    public void checkTest(){

    }
}
