package com.javaED.model.test;

import com.javaED.model.question.Question;

import java.util.List;

public class GeneralTest implements Test {
    private List<Question> questions;

    public GeneralTest(List<Question> questions) {
        this.questions = questions;
    }

    public GeneralTest() {}

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "GeneralTest{" +
                "questions=" + questions +
                '}';
    }
}
