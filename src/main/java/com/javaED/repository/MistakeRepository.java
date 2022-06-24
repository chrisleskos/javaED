package com.javaED.repository;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.question.Question;
import com.javaED.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MistakeRepository extends JpaRepository<Mistake, Integer> {

    @Query
    List<Mistake> findByUser(AppUser appUser);

    @Query("SELECT m FROM Mistake as m WHERE app_user_id = ?1 AND question_id = ?2")
    Optional<Mistake> findByUserAndQuestion(AppUser appUser, Question question);

    @Query("UPDATE Mistake as m SET m.count = m.count+1 WHERE m.id = ?1")
    void updateCount(Mistake mistake);
}
