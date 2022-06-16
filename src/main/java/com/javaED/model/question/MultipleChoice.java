package com.javaED.model.question;

import com.javaED.model.material.Section;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity( name = "multiple_choice")
@Table( name = "multiple_choice")
public class MultipleChoice extends Question {
    private String choice1;
    private String choice2;

    public MultipleChoice() {}

    public MultipleChoice(String questionSentence, String answer, String choice1, String choice2, Section section) {
        super(questionSentence, answer, section);
        this.choice1 = choice1;
        this.choice2 = choice2;

//        Collections.shuffle(choices);
    }

    public MultipleChoice(int id, String questionSentence, String answer, String choice1, String choice2, Section section) {
        super(id, questionSentence, answer, section);
        this.choice1 = choice1;
        this.choice2 = choice2;


//        Collections.shuffle(choices);
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public List<String> getChoices() {
        List<String> choices = new ArrayList<>();
        choices.add(this.choice1);
        choices.add(this.choice2);
        choices.add(this.answer);
        Collections.shuffle(choices);
        return choices;
    }

//    public void setChoices(List<String> choices) {
//        this.choices = choices;
//    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "choices='" + this.getChoices() + '\'' +
                ", id=" + id +
                ", questionSentence='" + questionSentence + '\'' +
                ", answer='" + answer + '\'' +
                ", section='" + section.toString() + '\'' +
                '}';
    }
}
