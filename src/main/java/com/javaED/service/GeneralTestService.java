package com.javaED.service;

import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import com.javaED.model.test.GeneralTest;
import com.javaED.model.test.Test;
import com.javaED.repository.SubmitGeneralTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GeneralTestService extends TestService{

    MultipleChoiceService multipleChoiceService;
    TrueOrFalseService trueOrFalseService;
    private final SubmitGeneralTestRepository submitGeneralTestRepository;


    @Autowired
    public GeneralTestService(
            MultipleChoiceService multipleChoiceService,
            TrueOrFalseService trueOrFalseService,
            QuestionService questionService,
            MistakeService mistakeService,
            SubmitGeneralTestRepository submitGeneralTestRepository) {
        super(questionService, mistakeService);
        this.multipleChoiceService = multipleChoiceService;
        this.trueOrFalseService = trueOrFalseService;
        this.submitGeneralTestRepository = submitGeneralTestRepository;
    }

    public GeneralTest getTest() {
        List<Question> questions = new ArrayList<>();

        // Gather all multiple
        List<MultipleChoice> multipleChoiceList = multipleChoiceService.getQuestions();
        List<TrueOrFalse> trueOrFalseList = trueOrFalseService.getQuestions();

        Collections.shuffle(multipleChoiceList);
        Collections.shuffle(trueOrFalseList);

        for(int i=0; i<3; i++)
            questions.add(multipleChoiceList.get(i));

        for(int i=0; i<3; i++)
            questions.add(trueOrFalseList.get(i));

        return new GeneralTest((MultipleChoice)questions.get(0), (MultipleChoice)questions.get(1), (MultipleChoice)questions.get(2),
                (TrueOrFalse)questions.get(3), (TrueOrFalse)questions.get(4), (TrueOrFalse)questions.get(5));
    }

    @Override
    public void saveTest(Test submittedTest) {
        this.submitGeneralTestRepository.save((GeneralTest)submittedTest);
    }
}
