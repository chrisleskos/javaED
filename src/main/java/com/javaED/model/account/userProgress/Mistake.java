package com.javaED.model.account.userProgress;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import com.javaED.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Mistake {
    @Id
    @SequenceGenerator(
            name = "mistake_sequence",
            sequenceName = "mistake_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mistake_sequence"
    )
    private int id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "question_id"
    )
    private Question question;

    private int count = 1;

    public Mistake(AppUser appUser, Question question) {
        this.appUser = appUser;
        this.question = question;
    }

    public Mistake(int id, AppUser appUser, Question question, int count) {
        this.id = id;
        this.appUser = appUser;
        this.question = question;
        this.count = count;
    }
}
