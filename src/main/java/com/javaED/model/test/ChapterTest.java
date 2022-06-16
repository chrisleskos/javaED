package com.javaED.model.test;

import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;

import java.util.List;

public class ChapterTest implements Test {
    private List<Question> questions;

    public ChapterTest(List<Question> questions) {
        this.questions = questions;
    }

    public ChapterTest() {}

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ChapterTest{" +
                "questions=" + questions +
                '}';
    }
}
