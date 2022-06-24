package com.javaED.model.test;

import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;

import java.util.List;

public class GeneralTest implements Test {
    private MultipleChoice question1;
    private MultipleChoice question2;
    private MultipleChoice question3;
    private TrueOrFalse question4;
    private TrueOrFalse question5;
    private TrueOrFalse question6;

    public GeneralTest(MultipleChoice question1, MultipleChoice question2, MultipleChoice question3, TrueOrFalse question4, TrueOrFalse question5, TrueOrFalse question6) {
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
        this.question6 = question6;
    }

    public List<Question> questionsAsList() {
        return List.of(question1, question2, question3, question4, question5, question6);
    }
}
