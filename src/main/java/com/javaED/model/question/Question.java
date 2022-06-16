package com.javaED.model.question;

import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;

import javax.persistence.*;


@Entity @Inheritance(strategy = InheritanceType.JOINED)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    protected Section section;


    public Question() {}

    public Question(String questionSentence, String answer, Section section) {
        this.questionSentence = questionSentence;
        this.answer = answer;
        this.section = section;
    }

    public Question(int id, String questionSentence, String answer, Section section) {
        this.id = id;
        this.questionSentence = questionSentence;
        this.answer = answer;
        this.section = section;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
