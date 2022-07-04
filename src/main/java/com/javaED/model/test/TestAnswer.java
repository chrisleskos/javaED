package com.javaED.model.test;

import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.material.Section;

public class TestAnswer {
    private int id;
    private String givenAnswer;
    private String correctAnswer;
    private boolean correct;
    private String section_title;
    private int mistake_count;

    public TestAnswer(int id, String givenAnswer) {
        this.id = id;
        this.givenAnswer = givenAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getSection_title() {
        return section_title;
    }

    public void setSection_title(String section_title) {
        this.section_title = section_title;
    }

    public int getMistake_count() {
        return mistake_count;
    }

    public void setMistake_count(int mistake_count) {
        this.mistake_count = mistake_count;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
