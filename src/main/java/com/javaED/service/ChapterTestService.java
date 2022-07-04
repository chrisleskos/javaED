package com.javaED.service;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import com.javaED.model.test.ChapterTest;
import com.javaED.model.test.Test;
import com.javaED.repository.SubmitChapterTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChapterTestService extends TestService {

    private final SubmitChapterTestRepository submitChapterTestRepository;

    @Autowired
    public ChapterTestService(QuestionService questionService, MistakeService mistakeService, SubmitChapterTestRepository submitChapterTestRepository) {
        super(questionService, mistakeService);
        this.submitChapterTestRepository = submitChapterTestRepository;
    }

    @Override
    public void saveTest(Test submittedTest) {
        this.submitChapterTestRepository.save((ChapterTest)submittedTest);
    }


    public List<ChapterTest> bestTest(Chapter chapter, AppUser appUser) {
        return submitChapterTestRepository.countTests(chapter, appUser);
    }


    public Test getTest(List<Section> sections) {

        // Collect separately the question types
        List<Question> multipleChoiceQuestions = new ArrayList<>();
        List<Question> trueOrFalseQuestions = new ArrayList<>();

        for (Section section : sections) {
            multipleChoiceQuestions.addAll(section.filterQuestionClass(MultipleChoice.class));
            trueOrFalseQuestions.addAll(section.filterQuestionClass(TrueOrFalse.class));
        }

        // Shuffle them
        Collections.shuffle(multipleChoiceQuestions);
        Collections.shuffle(trueOrFalseQuestions);

        return new ChapterTest((MultipleChoice)multipleChoiceQuestions.get(0), (MultipleChoice)multipleChoiceQuestions.get(1), (MultipleChoice)multipleChoiceQuestions.get(2),
                (TrueOrFalse)trueOrFalseQuestions.get(0), (TrueOrFalse)trueOrFalseQuestions.get(1), (TrueOrFalse)trueOrFalseQuestions.get(2));

    }

    public boolean hasPassedTest(Chapter chapter, AppUser appUser) {
        return submitChapterTestRepository.existsPassedTest(chapter, appUser) > 0;
    }
}
