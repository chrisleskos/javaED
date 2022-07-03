package com.javaED.service;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private ChapterRepository chapterRepository;
    private ChapterTestService chapterTestService;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository, ChapterTestService chapterTestService){
        this.chapterRepository = chapterRepository;
        this.chapterTestService = chapterTestService;
    }

    public List<Chapter> getChapters(AppUser appUser) {
        List<Chapter> chapters = chapterRepository.findAll();

        Chapter previousChapter = null;

        for (Chapter chapter:
             chapters) {
            if ( previousChapter != null) {
                if (chapterTestService.hasPassedTest(previousChapter, appUser)) {
                    chapter.setUnlocked(true);
                } else {
                    chapter.setUnlocked(false);
                }
            } else {
                chapter.setUnlocked(true);
            }

            previousChapter = chapter;
        }
        return chapters;
    }
}
