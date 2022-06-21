package com.javaED.model.account.userProgress;

import com.javaED.model.account.AppUser;
import com.javaED.model.test.ChapterTest;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubmittedGeneralTest {


    @Id
    @SequenceGenerator(
            name = "submitted_general_test_sequence",
            sequenceName = "submitted_general_test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "submitted_general_test_sequence"
    )
    private int id;
    private int score;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private AppUser appUser;

    public SubmittedGeneralTest (int score, AppUser appUser) {
        this.score = score;
        this.appUser = appUser;
    }
}
