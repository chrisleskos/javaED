package com.javaED.model.question;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collections;
import java.util.List;

@Entity( name = "multiple_choice")
@Table( name = "multiple_choice")
public class MultipleChoice extends Question {
    private String choice1;
    private String choice2;
    @Transient
    private List<String> choices;

    public MultipleChoice() {}

    public MultipleChoice(String questionSentence, String answer, String choice1, String choice2) {
        super(questionSentence, answer);
        this.choice1 = choice1;
        this.choice2 = choice2;

        choices = List.of(choice1, choice2, answer);
        Collections.shuffle(choices);
    }

    public MultipleChoice(int id, String questionSentence, String answer, String choice1, String choice2) {
        super(id, questionSentence, answer);
        this.choice1 = choice1;
        this.choice2 = choice2;
        Collections.shuffle(choices);
    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "choices='" + choices + '\'' +
                ", id=" + id +
                ", questionSentence='" + questionSentence + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
