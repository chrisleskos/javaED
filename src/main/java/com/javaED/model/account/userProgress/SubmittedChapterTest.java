package com.javaED.model.account.userProgress;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
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
public class SubmittedChapterTest {

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

    public SubmittedChapterTest(int score, Chapter chapter, AppUser appUser) {
        this.score = score;
        this.chapter = chapter;
        this.appUser = appUser;
    }
}
