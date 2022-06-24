package com.javaED.service;

import com.javaED.model.account.userProgress.SubmittedChapterTest;
import com.javaED.repository.SubmitChapterTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmitChapterTestService {

    private final SubmitChapterTestRepository submitChapterTestRepository;

    @Autowired
    public SubmitChapterTestService(SubmitChapterTestRepository submitChapterTestRepository) {
        this.submitChapterTestRepository = submitChapterTestRepository;
    }

    public void saveChapterTest(SubmittedChapterTest submittedChapterTest) {
        submitChapterTestRepository.save(submittedChapterTest);
    }
}
