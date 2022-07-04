package com.javaED.model.account.userProgress;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
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
            name = "section_id"
    )
    private Section section;

    private int count;

    public Mistake(AppUser appUser, Section section) {
        this.appUser = appUser;
        this.section = section;
        this.count = 1;
    }

    public Mistake(int id, AppUser appUser, Section section, int count) {
        this.id = id;
        this.appUser = appUser;
        this.section = section;
        this.count = count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Mistake{" +
                "id=" + id +
                ", appUser=" + appUser +
                ", section=" + section +
                ", count=" + count +
                '}';
    }

    public void increaseCount() {
        this.count++;
    }

    public void decreaseCount() {
        if (this.count > 0) this.count--;
    }
}
