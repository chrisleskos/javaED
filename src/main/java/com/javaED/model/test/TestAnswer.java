package com.javaED.model.test;

public class TestAnswer {
    private int id;
    private String givenAnswer;
    private boolean correct;

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

    @Override
    public String toString() {
        return "TestAnswer{" +
                "id=" + id +
                ", givenAnswer='" + givenAnswer + '\'' +
                '}';
    }
}
