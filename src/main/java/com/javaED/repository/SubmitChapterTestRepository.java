package com.javaED.repository;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.test.ChapterTest;
import com.javaED.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmitChapterTestRepository extends JpaRepository<ChapterTest, Integer> {

    @Query("SELECT COUNT(ct) FROM ChapterTest ct WHERE ct.chapter = ?1 AND ct.appUser = ?2 AND ct.score >= 3")
    int existsPassedTest(Chapter chapter, AppUser user);

    @Query("SELECT ct FROM ChapterTest ct WHERE ct.chapter = ?1 AND ct.appUser = ?2 ")
    List<ChapterTest> countTests(Chapter chapter, AppUser user);
}
