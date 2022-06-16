package com.javaED.service;

import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import com.javaED.model.test.GeneralTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GeneralTestService {

    MultipleChoiceService multipleChoiceService;
    TrueOrFalseService trueOrFalseService;

    @Autowired
    public GeneralTestService(
            MultipleChoiceService multipleChoiceService,
            TrueOrFalseService trueOrFalseService
            ) {
        this.multipleChoiceService = multipleChoiceService;
        this.trueOrFalseService = trueOrFalseService;
    }

    public GeneralTest getTest() {
        List<Question> questions = new ArrayList<>();

        // Gather all multiple
        List<MultipleChoice> multipleChoiceList = multipleChoiceService.getQuestions();
        List<TrueOrFalse> trueOrFalseList = trueOrFalseService.getQuestions();

        Collections.shuffle(multipleChoiceList);
        Collections.shuffle(trueOrFalseList);

        for(int i=0; i<3; i++)
            questions.add(multipleChoiceList.get(0));

        for(int i=0; i<3; i++)
            questions.add(trueOrFalseList.get(0));

        return new GeneralTest(questions);
    }
}
