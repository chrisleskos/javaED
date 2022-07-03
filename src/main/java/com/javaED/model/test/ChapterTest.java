package com.javaED.model.test;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@ToString
@Getter
@Setter
public class ChapterTest implements Test {

    @Id
    @SequenceGenerator(
            name = "submitted_chapter_test_sequence",
            sequenceName = "submitted_chapter_test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "submitted_chapter_test_sequence"
    )
    private int id;
    private int score;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "chapter_id"
    )
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private AppUser appUser;

    @Transient
    private MultipleChoice question1;
    @Transient
    private MultipleChoice question2;
    @Transient
    private MultipleChoice question3;
    @Transient
    private TrueOrFalse question4;
    @Transient
    private TrueOrFalse question5;
    @Transient
    private TrueOrFalse question6;

    public ChapterTest(MultipleChoice question1, MultipleChoice question2, MultipleChoice question3, TrueOrFalse question4, TrueOrFalse question5, TrueOrFalse question6) {
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
        this.question6 = question6;
    }

    public ChapterTest(int score, Chapter chapter, AppUser appUser) {
        this.score = score;
        this.chapter = chapter;
        this.appUser = appUser;
    }

    public List<Question> questionsAsList() {
        return List.of(question1, question2, question3, question4, question5, question6);
    }
}
