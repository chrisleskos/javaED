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

        List<Question> questions = new ArrayList<>();


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


        // Get 3 Multiple choice questions
        for (int i=0; i<3; i++) {
            MultipleChoice q = (MultipleChoice) multipleChoiceQuestions.remove(0);
            questions.add(q);
        }

        // Get 3 True or False questions
        for (int i=0; i<3; i++){
            TrueOrFalse q = (TrueOrFalse) trueOrFalseQuestions.remove(0);
            questions.add(q);
        }


        return new ChapterTest(questions);

    }
}
