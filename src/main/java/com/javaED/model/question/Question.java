package com.javaED.model.question;

import javax.persistence.*;


@MappedSuperclass
public abstract class Question {
    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    @Column(
            name = "question_id"
    )
    protected int id;
    protected String questionSentence;
    protected String answer;

    public Question() {}

    public Question(String questionSentence, String answer) {
        this.questionSentence = questionSentence;
        this.answer = answer;
    }

    public Question(int id, String questionSentence, String answer) {
        this.id = id;
        this.questionSentence = questionSentence;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionSentence() {
        return questionSentence;
    }

    public void setQuestionSentence(String questionSentence) {
        this.questionSentence = questionSentence;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
