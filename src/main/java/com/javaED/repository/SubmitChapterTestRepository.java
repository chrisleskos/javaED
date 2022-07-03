package com.javaED.repository;

import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.test.ChapterTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitChapterTestRepository extends JpaRepository<ChapterTest, Integer> {

    @Query("SELECT CASE WHEN COUNT(ct) > 0 THEN true ELSE false END FROM ChapterTest ct WHERE ct.chapter = ?1 AND ct.appUser = ?2 AND ct.score >= 3")
    boolean existsPassedTest(Chapter chapter, AppUser user);
}
