package com.javaED.model.material;

import com.javaED.model.question.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Chapter")
@Table
public class Chapter {
    @Id
    @SequenceGenerator(
            name = "chapter_sequence",
            sequenceName = "chapter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "chapter_sequence"
    )
    @Column(
            name = "chapter_id"
    )
    private int id;

    @Column(
            unique = true,
            nullable = false
    )
    private String title;

    private boolean unlocked;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Section> sections = new ArrayList<>();

    public Chapter(){}

    public Chapter(String title, boolean unlocked) {
        this.title = title;
        this.unlocked = unlocked;
    }

    public Chapter(int id, String title, boolean unlocked) {
        this.title = title;
        this.unlocked = unlocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSection(List<Section> section) {
        this.sections = section;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", unlocked=" + unlocked +
                ", sections=" + sections.toString() +
                '}';
    }

    public boolean completed() {
        return true;
    }
}
