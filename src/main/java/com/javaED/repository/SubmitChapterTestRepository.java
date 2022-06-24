package com.javaED.repository;

import com.javaED.model.account.userProgress.SubmittedChapterTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitChapterTestRepository extends JpaRepository<SubmittedChapterTest, Integer> {
}
