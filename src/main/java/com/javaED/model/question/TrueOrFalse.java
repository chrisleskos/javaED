package com.javaED.model.question;

import com.javaED.model.material.Section;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity( name = "true_or_false")
@Table( name = "true_or_false")
public class TrueOrFalse extends Question {

    public TrueOrFalse() {}

    public TrueOrFalse(String questionSentence, String answer, Section section) {
        super(questionSentence, answer, section);
    }

    public TrueOrFalse(int id, String questionSentence, String answer, Section section) {
        super(id, questionSentence, answer, section);
    }

    @Override
    public String toString() {
        return "TrueOrFalse{" +
                "id=" + id +
                ", questionSentence='" + questionSentence + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", section='" + section.toString() + '\'' +
                '}';

    }
}
