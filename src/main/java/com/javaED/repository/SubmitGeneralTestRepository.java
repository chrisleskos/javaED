package com.javaED.repository;


import com.javaED.model.account.AppUser;
import com.javaED.model.material.Chapter;
import com.javaED.model.test.GeneralTest;
import com.javaED.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmitGeneralTestRepository extends JpaRepository<GeneralTest, Integer> {

    @Query("SELECT ct FROM ChapterTest ct WHERE ct.appUser = ?1 ")
    List<GeneralTest> countTests(AppUser user);
}
