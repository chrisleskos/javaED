package com.javaED.model.material;

import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Section")
@Table
public class Section {
    @Id
    @SequenceGenerator(
            name = "section_sequence",
            sequenceName = "section_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "section_sequence"
    )
    @Column(
            name = "section_id"
    )
    private int id;

    @Column(
            unique = true,
            nullable = false
    )
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

    public Section(){}

    public Section(String title, String content, Chapter chapter) {
        this.title = title;
        this.content = content;
        this.chapter = chapter;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> filterQuestionClass(Class questionClass) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question q:
             questions) {
            if (q.getClass().equals(questionClass))
                filteredQuestions.add(q);
        }

        return filteredQuestions;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", chapter=" + chapter.getId() +
                '}';
    }
}
