package com.javaED.service;

import com.javaED.model.Chapter;
import com.javaED.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository){
        this.chapterRepository = chapterRepository;
    }

    public List<Chapter> getChapters() {
        return chapterRepository.findAll();
    }
}
