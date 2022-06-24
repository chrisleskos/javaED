package com.javaED.service;

import com.javaED.model.material.Section;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import com.javaED.model.test.ChapterTest;
import com.javaED.repository.MultipleChoiceRepository;
import com.javaED.repository.TrueOrFalseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChapterTestService {

    private MultipleChoiceRepository multipleChoiceRepository;
    private TrueOrFalseRepository truorFalseRepository;

    @Autowired
    public ChapterTestService(
            MultipleChoiceRepository multipleChoiceRepository,
            TrueOrFalseRepository truorFalseRepository
    ) {

    }

    public ChapterTest getTest(List<Section> sections) {

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

    public int checkTest(ChapterTest chapterTest) {
        int score = 0;

        for (Question q:
             chapterTest.questionsAsList()) {
//            q.
        }
        return 2;
    }
}
