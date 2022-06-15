package com.javaED.model.question;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity( name = "true_or_false")
@Table( name = "true_or_false")
public class TrueOrFalse extends Question {

    public TrueOrFalse() {}

    public TrueOrFalse(String questionSentence, String answer) {
        super(questionSentence, answer);
    }

    public TrueOrFalse(int id, String questionSentence, String answer) {
        super(id, questionSentence, answer);
    }

    @Override
    public String toString() {
        return "TrueOrFalse{" +
                "id=" + id +
                ", questionSentence='" + questionSentence + '\'' +
                '}';
    }
}
